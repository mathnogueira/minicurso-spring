package ag.orbia.minicurso.authentication

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class LoginService : UserDetailsService {
	override fun loadUserByUsername(username: String?): UserDetails {
		val userDetails = UserLogin()
		return userDetails
	}
}
