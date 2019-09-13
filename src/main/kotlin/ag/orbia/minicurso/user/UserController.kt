package ag.orbia.minicurso.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/user")
class UserController {

	@Autowired
	lateinit var userService: UserService

	@GetMapping("/register")
	fun getUserRegisterPage(): ModelAndView {
		return ModelAndView("register")
	}

	@PostMapping("/register")
	fun createUser(userModel: UserModel): ModelAndView {
		userService.save(userModel)
		return ModelAndView("redirect:/login")
	}
}
