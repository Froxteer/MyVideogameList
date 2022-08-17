package service

import dao.DeveloperDao
import entity.Developer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DeveloperService(@Autowired val developerDao: DeveloperDao) {

    fun getAllDevelopers(): List<Developer> {
        return developerDao.getAll()
    }

}