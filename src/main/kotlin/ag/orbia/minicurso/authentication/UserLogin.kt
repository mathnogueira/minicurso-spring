package ag.orbia.minicurso.authentication

import ag.orbia.minicurso.user.UserModel
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserLogin(private val user: UserModel) : UserDetails {

	override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
		return listOf(SimpleGrantedAuthority("USER")).toMutableList()
	}

	override fun isEnabled(): Boolean {
		return true
	}

	override fun getUsername(): String {
		return user.email
	}

	override fun isCredentialsNonExpired(): Boolean {
		return true
	}

	override fun getPassword(): String {
		return user.password
	}

	override fun isAccountNonExpired(): Boolean {
		return true
	}

	override fun isAccountNonLocked(): Boolean {
		return true
	}
}
