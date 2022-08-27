package rest

import classes.CustomResponse
import entity.VideoGame
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import service.VideoGameService
import javax.servlet.http.HttpServletRequest

@RestController
class VideoGameRestController(@Autowired val videoGameService: VideoGameService) {

    @GetMapping("/video_game/all")
    fun getAllVideoGames(@RequestParam(required = false) userId: Int?): List<VideoGame> {
        return videoGameService.getAllVideoGames(userId)
    }

    @ExceptionHandler(Exception::class)
    fun handleIncorrectData(req: HttpServletRequest, ex: Exception): ResponseEntity<CustomResponse> {
        return ResponseEntity.badRequest()
            .body(CustomResponse(400, req.requestURI, ex.message))
    }

}