package ag.orbia.minicurso.question

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class QuestionService {
    @Autowired
    lateinit var repository: QuestionRepository;

    fun findAll(): List<QuestionModel> {
        return repository.findAll();
    }

    fun create(question: QuestionModel) : QuestionModel {
        return repository.save(question);
    }
}