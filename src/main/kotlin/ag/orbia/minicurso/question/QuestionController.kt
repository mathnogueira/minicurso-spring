package ag.orbia.minicurso.question

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class QuestionController {

    @Autowired
    lateinit var repository: QuestionRepository;

    @GetMapping(value = "/")
    fun listQuestions() : ModelAndView {
        val questions = repository.findAll();
        val result = ModelAndView("questions")
        result.addObject(questions)
        return result
    }
}