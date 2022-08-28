package entity.key

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class VideoGameUserKey(
    @Column(name = "video_game_id")
    var videoGameId: Int?,

    @Column(name = "user_id")
    var userId: Int?
): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VideoGameUserKey

        if (videoGameId != other.videoGameId) return false
        if (userId != other.userId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = videoGameId
        result = 31 * result!! + userId!!
        return result
    }
}