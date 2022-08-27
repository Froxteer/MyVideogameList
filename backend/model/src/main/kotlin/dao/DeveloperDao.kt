package dao

import entity.Developer
import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Component
class DeveloperDao(@PersistenceContext val entityManager: EntityManager): Dao<Developer> {
    override fun get(id: Int): Optional<Developer> {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Developer> {
        val criteriaQuery = entityManager.criteriaBuilder.createQuery(Developer::class.java)
        return entityManager.createQuery(criteriaQuery.select(criteriaQuery.from(Developer::class.java))).resultList
    }

    override fun delete(t: Developer) {
        TODO("Not yet implemented")
    }

    override fun update(t: Developer) {
        TODO("Not yet implemented")
    }

    override fun save(t: Developer): Developer {
        TODO("Not yet implemented")
    }
}