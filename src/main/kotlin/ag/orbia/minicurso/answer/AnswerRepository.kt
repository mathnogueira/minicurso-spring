package ag.orbia.minicurso.answer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnswerRepository: JpaRepository<AnswerModel, Long> {

}