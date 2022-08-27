package dao

import entity.Platform
import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Component
class PlatformDao(@PersistenceContext val entityManager: EntityManager): Dao<Platform> {
    override fun get(id: Int): Optional<Platform> {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Platform> {
        val criteriaQuery = entityManager.criteriaBuilder.createQuery(Platform::class.java)
        return entityManager.createQuery(criteriaQuery.select(criteriaQuery.from(Platform::class.java))).resultList
    }

    override fun delete(t: Platform) {
        TODO("Not yet implemented")
    }

    override fun update(t: Platform) {
        TODO("Not yet implemented")
    }

    override fun save(t: Platform): Platform {
        TODO("Not yet implemented")
    }
}