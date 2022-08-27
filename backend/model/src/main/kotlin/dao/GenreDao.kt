package dao

import entity.Genre
import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Component
class GenreDao(@PersistenceContext val entityManager: EntityManager): Dao<Genre> {

    override fun get(id: Int): Optional<Genre> {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Genre> {
        val criteriaQuery = entityManager.criteriaBuilder.createQuery(Genre::class.java)
        return entityManager.createQuery(criteriaQuery.select(criteriaQuery.from(Genre::class.java))).resultList
    }

    override fun delete(t: Genre) {
        TODO("Not yet implemented")
    }

    override fun update(t: Genre) {
        TODO("Not yet implemented")
    }

    override fun save(t: Genre): Genre {
        TODO("Not yet implemented")
    }
}