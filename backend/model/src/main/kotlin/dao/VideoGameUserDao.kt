package dao

import entity.VideoGameUser
import entity.key.VideoGameUserKey
import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Component
class VideoGameUserDao(@PersistenceContext val entityManager: EntityManager): Dao<VideoGameUser> {
    override fun get(id: Int): Optional<VideoGameUser> {
        TODO("Not yet implemented")
    }

    fun getByCompositeId(id: VideoGameUserKey): Optional<VideoGameUser> {
        return Optional.ofNullable(entityManager.find(VideoGameUser::class.java, id))
    }

    override fun getAll(): List<VideoGameUser> {
        TODO("Not yet implemented")
    }

    override fun delete(t: VideoGameUser) {
        entityManager.remove(t)
    }

    override fun update(t: VideoGameUser) {
        entityManager.merge(t)
    }

    override fun save(t: VideoGameUser): VideoGameUser {
        entityManager.persist(t)
        return t
    }
}