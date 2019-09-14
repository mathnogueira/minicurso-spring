package ag.orbia.minicurso.question

import java.util.*

data class QuestionDTO (
		var title : String,
		var creationDate : Date,
		var authorId : Long,
		var authorName : String
)
