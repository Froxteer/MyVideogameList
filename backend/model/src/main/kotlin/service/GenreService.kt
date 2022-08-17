package service

import dao.GenreDao
import entity.Genre
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GenreService(@Autowired val genreDao: GenreDao) {

    fun getAllGenres(): List<Genre> {
        return genreDao.getAll()
    }

}