package dao

import org.springframework.transaction.annotation.Transactional
import java.util.*

interface Dao<T> {

    fun get(id: Int): Optional<T>

    fun getAll(): List<T>

    @Transactional
    fun save(t: T): T

    @Transactional
    fun update(t: T)

    @Transactional
    fun delete(t: T)

}