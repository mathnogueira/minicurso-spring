package ag.orbia.minicurso.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService {

	@Autowired
	private lateinit var userRepository: UserRepository

	@Autowired
	private lateinit var passwordEncoder: BCryptPasswordEncoder

	fun save(user: UserModel): UserModel {
		val userToSave = UserModel(
				name = user.name,
				email = user.email,
				password = passwordEncoder.encode(user.password)
		)

		return userRepository.save(userToSave)
	}
}
