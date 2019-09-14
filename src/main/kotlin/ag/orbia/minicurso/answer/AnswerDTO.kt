package ag.orbia.minicurso.answer

import java.util.*

data class AnswerDTO (
		var body : String,
		var creationDate : Date,
		var authorId : Long,
		var authorName : String
)
