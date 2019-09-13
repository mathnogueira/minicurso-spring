package ag.orbia.minicurso.user

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

@Entity
@Table(name = "user", schema = "forum")
data class UserModel(
		@Id
		@SequenceGenerator(name = "UserGen", schema = "forum", allocationSize = 1, initialValue = 1, sequenceName = "user_sequence")
		@GeneratedValue(generator = "UserGen")
		val id: Long = 0,

		@NotNull
		val name: String = "",
		@NotNull
		@Email
		val email: String = "",

		@NotNull
		val password: String = "") {
}
