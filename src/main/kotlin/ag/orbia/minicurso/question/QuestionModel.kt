package ag.orbia.minicurso.question

import ag.orbia.minicurso.user.UserModel
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "question", schema = "forum")
data class QuestionModel(
		@Id
		@SequenceGenerator(name = "QuestionGen", schema = "forum", allocationSize = 1, initialValue = 1, sequenceName = "question_sequence")
		@GeneratedValue(generator = "QuestionGen")
		val id: Long = 0,

		@NotNull
		val title: String = "",
		@NotNull
		val body: String = "",
		@NotNull
		val creationDate: Date = Date(0),
		@NotNull
		@ManyToOne
		val author: UserModel = UserModel()
)
