package app

import classes.Genre
import classes.VideoGame
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import kotlin.reflect.KClass

@SpringBootApplication(scanBasePackages = ["app", "rest", "classes"])
@EntityScan(basePackageClasses = [VideoGame::class, Genre::class])
class BackendApplication

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}