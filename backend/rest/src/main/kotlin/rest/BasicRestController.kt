package rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BasicRestController {

    @GetMapping("/test")
    fun test(): String {
        return "Hello World"
    }

}