package rest

import classes.VideoGame
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@RestController
class BasicRestController(@PersistenceContext val entityManager: EntityManager) {

    @GetMapping("/test")
    fun test(): String {
        return "Hello World"
    }

    @PostMapping("/insert")
    @Transactional
    fun insertVideoGame(@RequestBody videoGame: VideoGame): ResponseEntity<String> {
        return try {
            entityManager.persist(videoGame)
            ResponseEntity.accepted().body("Object VideoGame inserted successfully") //TODO
        } catch (e: Exception) {
            ResponseEntity.badRequest().body("Object VideoGame must contain at least {name: String, releaseDate: String(YYYY-MM-DD)}")
        }
    }

}