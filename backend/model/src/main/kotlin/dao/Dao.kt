package dao

import java.util.*

interface Dao<T> {

    fun get(id: Int): Optional<T>

    fun getAll(): List<T>

    fun save(t: T)

    fun update(t: T)

    fun delete(t: T)

}