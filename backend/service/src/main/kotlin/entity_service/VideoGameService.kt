package entity_service

import entity.VideoGame
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Service
class VideoGameService(@PersistenceContext val entityManager: EntityManager) {

    fun getVideoGame(id: Int): VideoGame {
        return entityManager.find(VideoGame::class.java, id)
    }

    @Transactional
    fun insertCompleteVideoGame(videoGame: VideoGame) {
        videoGame.genres?.forEach { entityManager.persist(it) }
        videoGame.companies?.forEach { entityManager.persist(it) }
        videoGame.platforms?.forEach { entityManager.persist(it.developer) }
        videoGame.platforms?.forEach { entityManager.persist(it) }
        entityManager.persist(videoGame)
    }

}