package rest

import classes.VideoGame
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
    fun insertVideoGame(@RequestBody videoGame: VideoGame) {
        entityManager.persist(videoGame)
    }

}