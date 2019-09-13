package ag.orbia.minicurso.answer

import ag.orbia.minicurso.question.QuestionModel
import ag.orbia.minicurso.user.UserModel
import org.springframework.data.annotation.Id
import java.util.*
import javax.persistence.*
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
        @ManyToOne
        val question: QuestionModel = QuestionModel(),
        @NotNull
        val answerDate: Date = Date(0),
        @NotNull
        @ManyToOne
        val author: UserModel = UserModel()
)