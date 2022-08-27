package dao

import entity.VideoGame
import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Component
class VideoGameDao(@PersistenceContext val entityManager: EntityManager): Dao<VideoGame> {
    override fun get(id: Int): Optional<VideoGame> {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<VideoGame> {
        val criteriaQuery = entityManager.criteriaBuilder.createQuery(VideoGame::class.java)
        return entityManager.createQuery(criteriaQuery.select(criteriaQuery.from(VideoGame::class.java))).resultList
    }

    override fun delete(t: VideoGame) {
        TODO("Not yet implemented")
    }

    override fun update(t: VideoGame) {
        TODO("Not yet implemented")
    }

    override fun save(t: VideoGame): VideoGame {
        TODO("Not yet implemented")
    }
}