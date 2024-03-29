package ag.orbia.minicurso.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserModel, Long> {
	fun findByEmail(email: String): UserModel?
}
