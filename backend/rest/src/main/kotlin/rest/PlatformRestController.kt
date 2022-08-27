package rest

import classes.CustomResponse
import entity.Platform
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import service.PlatformService
import javax.servlet.http.HttpServletRequest

@RestController
class PlatformRestController(@Autowired val platformService: PlatformService) {

    @GetMapping("platform/all")
    fun getAllPlatforms(): List<Platform> {
        return platformService.getAllPlatforms()
    }

    @ExceptionHandler(Exception::class)
    fun handleIncorrectData(req: HttpServletRequest, ex: Exception): ResponseEntity<CustomResponse> {
        return ResponseEntity.badRequest()
            .body(CustomResponse(400, req.requestURI, ex.message))
    }
}