package rest

import classes.CustomResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@RestController
class VideoGameRestController(/*@Autowired val videoGameService: VideoGameService*/) {

    /*@GetMapping("get/{id}")
    fun getVideoGame(@PathVariable id: Int): VideoGame {
        return videoGameService.getVideoGame(id)
    }*/

    /*@PostMapping("/insert")
    fun insertCompleteVideoGame(@RequestBody videoGame: VideoGame): ResponseEntity<CustomResponse> {
        videoGameService.insertCompleteVideoGame(videoGame)
        return ResponseEntity.accepted()
            .body(CustomResponse(202, "/insert", "Object VideoGame inserted successfully"))
    }*/

    @ExceptionHandler(Exception::class)
    fun handleIncorrectData(req: HttpServletRequest, ex: Exception): ResponseEntity<CustomResponse> {
        return ResponseEntity.badRequest()
            .body(CustomResponse(400, req.requestURI, ex.localizedMessage))
    }

}