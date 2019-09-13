package ag.orbia.minicurso.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

	@Bean
	fun passwordEncoder(): BCryptPasswordEncoder {
		return BCryptPasswordEncoder(12)
	}

	override fun configure(http: HttpSecurity) {
		http
				.cors().and().csrf().disable()
				.authorizeRequests()
				.antMatchers("/user/register", "/home").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
					.successForwardUrl("/questions")
				.and()
				.httpBasic()
	}
}
