package entity

import com.fasterxml.jackson.annotation.JsonBackReference
import entity.key.VideoGameUserKey
import entity.utils.ListConcept
import javax.persistence.*

@Entity
@Table(name = "video_game_user")
class VideoGameUser(
    @EmbeddedId
    var id: VideoGameUserKey,

    @ManyToOne
    @MapsId("videoGameId")
    @JoinColumn(name = "video_game_id")
    @JsonBackReference("video_game_video_game_user")
    var videoGame: VideoGame,

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonBackReference("user_video_game_user")
    var user: User,

    @Enumerated(EnumType.STRING)
    @Column(name = "list_concept", nullable = false)
    var listConcept: ListConcept
)