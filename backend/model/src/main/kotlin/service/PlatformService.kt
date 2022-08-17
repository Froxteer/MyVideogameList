package service

import dao.PlatformDao
import entity.Platform
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlatformService(@Autowired val platformDao: PlatformDao) {

    fun getAllPlatforms(): List<Platform> {
        return platformDao.getAll()
    }

}