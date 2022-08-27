package app

import entity.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["app", "rest", "classes", "service", "dao"])
@EntityScan(basePackageClasses = [VideoGame::class, Genre::class, Platform::class,
    Developer::class, User::class, VideoGameUser::class])
class BackendApplication

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}