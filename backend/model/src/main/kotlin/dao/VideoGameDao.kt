package dao

import entity.VideoGame
import entity.VideoGameUser
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Component
class VideoGameDao(@PersistenceContext val entityManager: EntityManager): Dao<VideoGame> {
    override fun get(id: Int): Optional<VideoGame> {
        return Optional.ofNullable(entityManager.find(VideoGame::class.java, id))
    }

    override fun getAll(): List<VideoGame> {
        val criteriaQuery = entityManager.criteriaBuilder.createQuery(VideoGame::class.java)
        return entityManager.createQuery(criteriaQuery.select(criteriaQuery.from(VideoGame::class.java))).resultList
    }

    fun getAllAssigned(userId: Int): List<VideoGame> {
        return entityManager.createQuery(
            "SELECT v FROM VideoGame v INNER JOIN VideoGameUser vu ON v.id = vu.videoGame.id WHERE vu.user.id = :userId", VideoGame::class.java)
            .setParameter("userId", userId).resultList
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