package rest

import classes.CustomResponse
import entity.Developer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import service.DeveloperService
import javax.servlet.http.HttpServletRequest

@RestController
class DeveloperRestController(@Autowired val developerService: DeveloperService) {

    @GetMapping("/developer/all")
    fun getAllDevelopers(): List<Developer> {
        return developerService.getAllDevelopers()
    }

    @ExceptionHandler(Exception::class)
    fun handleIncorrectData(req: HttpServletRequest, ex: Exception): ResponseEntity<CustomResponse> {
        return ResponseEntity.badRequest()
            .body(CustomResponse(400, req.requestURI, ex.localizedMessage))
    }

}