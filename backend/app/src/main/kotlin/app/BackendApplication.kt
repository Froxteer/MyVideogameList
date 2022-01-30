package app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["app", "rest"])
class BackendApplication

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}