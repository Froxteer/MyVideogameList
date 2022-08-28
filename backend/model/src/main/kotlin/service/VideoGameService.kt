package service

import dao.UserDao
import dao.VideoGameDao
import dao.VideoGameUserDao
import entity.VideoGame
import entity.VideoGameUser
import entity.key.VideoGameUserKey
import entity.utils.ListConcept
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.Objects

@Service
class VideoGameService(
    @Autowired val videoGameDao: VideoGameDao,
    @Autowired val userDao: UserDao,
    @Autowired val videoGameUserDao: VideoGameUserDao
) {

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

    fun persistVideoGameRelation(userId: Int, videoGameId: Int, conceptId: Int) {
        val user = userDao.get(userId)
        val videoGame = videoGameDao.get(videoGameId)
        val videoGameUser: VideoGameUser

        if (videoGame.isPresent && user.isPresent) {
            val key = VideoGameUserKey(videoGameId, userId)
            val optionalVideoGameUser = videoGameUserDao.getByCompositeId(key)
            if (optionalVideoGameUser.isPresent) {
                videoGameUser = optionalVideoGameUser.get()

                if (conceptId == 0) {
                    videoGameUserDao.delete(videoGameUser)
                    return
                }

                when(conceptId) {
                    1 -> videoGameUser.listConcept = ListConcept.PLAYED
                    2 -> videoGameUser.listConcept = ListConcept.PLAYING
                    3 -> videoGameUser.listConcept = ListConcept.ON_QUEUE
                }
                videoGameUserDao.update(videoGameUser)
            } else {
                videoGameUser = when(conceptId) {
                    1 -> VideoGameUser(VideoGameUserKey(null, null), videoGame.get(), user.get(), ListConcept.PLAYED)
                    2 -> VideoGameUser(VideoGameUserKey(null, null), videoGame.get(), user.get(), ListConcept.PLAYING)
                    3 -> VideoGameUser(VideoGameUserKey(null, null), videoGame.get(), user.get(), ListConcept.ON_QUEUE)
                    else -> return
                }
                videoGameUserDao.save(videoGameUser)
            }
        }
    }

}