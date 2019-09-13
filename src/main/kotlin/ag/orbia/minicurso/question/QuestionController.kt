package ag.orbia.minicurso.question

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.servlet.ModelAndView

@Controller
class QuestionController {

    @Autowired
    lateinit var service: QuestionService;

    @GetMapping("/questions/new")
    fun createQuestion(): ModelAndView {
        return ModelAndView("new_question")
    }

    @PostMapping("/questions/new")
    fun saveQuestion(@RequestBody question: QuestionModel) : ModelAndView {
        val created_question = service.create(question);
        val result = ModelAndView("question");
        result.addObject(created_question);
        return result;
    }

    @GetMapping(value = "/questions")
    fun listQuestions() : ModelAndView {
        val questions = service.findAll();
        val result = ModelAndView("questions")
        result.addObject(questions)
        return result
    }
}