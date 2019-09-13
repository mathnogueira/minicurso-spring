package ag.orbia.minicurso.authentication

import ag.orbia.minicurso.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class LoginService : UserDetailsService {

	@Autowired
	lateinit var userRepository: UserRepository

	override fun loadUserByUsername(username: String): UserDetails {
		val user = userRepository.findByEmail(username)
		if (user == null) {
			throw UsernameNotFoundException("User not found")
		}

		return UserLogin(user)
	}
}
