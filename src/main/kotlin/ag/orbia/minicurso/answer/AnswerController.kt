package ag.orbia.minicurso.answer

import ag.orbia.minicurso.question.QuestionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/answer")
class AnswerController {

	@Autowired
	lateinit var repository: AnswerRepository

	@Autowired
	lateinit var repositoryQuestion: QuestionRepository


	@PostMapping(name = "")
	fun create(@RequestBody answer:AnswerModel)  {
		repository.save(answer)
	}

	@GetMapping("/{id}")
	fun listAnswers(@PathVariable("id") id:Long):List<AnswerDTO>{
		var question = repositoryQuestion.findById(id).get()
		var answers = repository.findByQuestion(question)
//		var list = ArrayList<AnswerDTO>()
//		for (answer in answers){
//			list.add(AnswerDTO(
//					body = answer.body,
//					creationDate = answer.answerDate,
//					authorId = answer.author.id,
//					authorName = answer.author.name
//			))
//		}
		return answers.map { answer -> AnswerDTO(
			body = answer.body,
			creationDate = answer.answerDate,
			authorId = answer.author.id,
			authorName = answer.author.name
		) }
	}
}
