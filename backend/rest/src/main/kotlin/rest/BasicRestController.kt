package rest

import classes.VideoGame
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.servlet.http.HttpServletRequest

@RestController
class BasicRestController(@PersistenceContext val entityManager: EntityManager) {

    @GetMapping("/test")
    fun test(): String {
        return "Hello World"
    }

    @PostMapping("/insert")
    @Transactional
    fun insertVideoGame(@RequestBody videoGame: VideoGame): ResponseEntity<String> {
        entityManager.persist(videoGame)
        return ResponseEntity.accepted().body("Object VideoGame inserted successfully")
    }

    @ExceptionHandler(Exception::class)
    fun handleIncorrectData(req: HttpServletRequest, ex: Exception): ResponseEntity<String> {
        return ResponseEntity.badRequest().body("Request: " + req.requestURL + " raised " + ex.message)
    }



}