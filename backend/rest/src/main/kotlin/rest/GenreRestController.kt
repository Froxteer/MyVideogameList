package rest

import classes.CustomResponse
import entity.Genre
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import service.GenreService
import javax.servlet.http.HttpServletRequest

@RestController
class GenreRestController(@Autowired val genreService: GenreService) {

    @GetMapping("/genre/all")
    fun getAllGenres(): List<Genre> {
        return genreService.getAllGenres()
    }

    @ExceptionHandler(Exception::class)
    fun handleIncorrectData(req: HttpServletRequest, ex: Exception): ResponseEntity<CustomResponse> {
        return ResponseEntity.badRequest()
            .body(CustomResponse(400, req.requestURI, ex.message))
    }

}