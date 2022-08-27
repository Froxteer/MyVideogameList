package dao

import entity.User
import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Component
class UserDao(@PersistenceContext val entityManager: EntityManager): Dao<User> {
    override fun get(id: Int): Optional<User> {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<User> {
        TODO("Not yet implemented")
    }

    override fun delete(t: User) {
        TODO("Not yet implemented")
    }

    override fun update(t: User) {
        TODO("Not yet implemented")
    }

    override fun save(t: User): User {
        entityManager.persist(t)
        return t
    }

    fun getByUsername(username: String): User {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.username=:username", User::class.java)
            .setParameter("username", username).singleResult
    }
}