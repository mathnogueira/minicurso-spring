package ag.orbia.minicurso.question

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.collections.ArrayList

@RestController
@RequestMapping("/question")
class QuestionController {

    @Autowired
    lateinit var repository: QuestionRepository

    @GetMapping (name = "")
    fun viewQuestion() : List<QuestionDTO>{
        var dataQuestion = repository.findAll()
        var list = ArrayList<QuestionDTO>()
        for (question in dataQuestion) {
            list.add(QuestionDTO(
                    title = question.title,
                    authorId = question.author.id,
                    authorName = question.author.name,
                    creationDate = question.creationDate
            ))
        }
        return list
    }

    @PostMapping (name = "")
    fun createQuestion(@RequestBody question : QuestionModel) {
        val dataAtual = Date()
        question.creationDate = dataAtual
        repository.save(question)
    }
}
