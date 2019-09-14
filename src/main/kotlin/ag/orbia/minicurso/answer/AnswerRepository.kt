package ag.orbia.minicurso.answer

import ag.orbia.minicurso.question.QuestionModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnswerRepository: JpaRepository<AnswerModel, Long> {

	fun findByQuestion ( question : QuestionModel ) : List<AnswerModel>
}
