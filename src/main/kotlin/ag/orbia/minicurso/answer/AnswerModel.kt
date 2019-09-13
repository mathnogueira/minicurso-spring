package ag.orbia.minicurso.answer

import ag.orbia.minicurso.question.QuestionModel
import ag.orbia.minicurso.user.UserModel
import org.springframework.data.annotation.Id
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.SequenceGenerator
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
data class AnswerModel(
        @Id
        @SequenceGenerator(name = "AnswerGen", schema = "forum", allocationSize = 1, initialValue = 1, sequenceName = "answer_sequence")
        @GeneratedValue(generator = "AnswerGen")
        val id: Long = 0,
        @NotEmpty
        val body: String = "",
        @NotNull
        val question: QuestionModel = QuestionModel(),
        @NotNull
        val responseDate: Date = Date(0),
        @NotNull
        val author: UserModel = UserModel()
)