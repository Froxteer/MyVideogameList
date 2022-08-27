package service

import dao.VideoGameDao
import entity.VideoGame
import entity.VideoGameUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Objects

@Service
class VideoGameService(@Autowired val videoGameDao: VideoGameDao) {

    fun getAllVideoGames(userId: Int?): List<VideoGame> {
        val videoGames = videoGameDao.getAll()

        if (Objects.isNull(userId)) {
            videoGames.forEach { videoGame -> videoGame.videoGameUsers = null }
        } else {
            for (videoGame in videoGames) {
                val parsedVideoGameUsers = mutableListOf<VideoGameUser>()
                for (videoGameUser in videoGame.videoGameUsers!!) {
                    if (Objects.equals(videoGameUser.user.id, userId)) {
                        parsedVideoGameUsers.add(videoGameUser)
                    }
                }
                videoGame.videoGameUsers = parsedVideoGameUsers
            }
        }

        return videoGames
    }

}