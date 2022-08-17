package service

import dao.VideoGameDao
import entity.VideoGame
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VideoGameService(@Autowired val videoGameDao: VideoGameDao) {

    fun getAllVideoGames(): List<VideoGame> {
        return videoGameDao.getAll()
    }

}