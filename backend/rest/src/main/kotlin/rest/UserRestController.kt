package rest

import classes.CustomResponse
import entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import service.UserService
import javax.servlet.http.HttpServletRequest

@RestController
class UserRestController(@Autowired val userService: UserService) {

    @PostMapping("user/save")
    fun saveUser(@RequestBody user: User): User {
        return userService.saveUser(user)
    }

    @GetMapping("user/login")
    fun logIn(@RequestParam username: String, @RequestParam password: String): User {
        return userService.logIn(username, password)
    }

    @ExceptionHandler(Exception::class)
    fun handleIncorrectData(req: HttpServletRequest, ex: Exception): ResponseEntity<CustomResponse> {
        return ResponseEntity.badRequest()
            .body(CustomResponse(400, req.requestURI, ex.message))
    }

}