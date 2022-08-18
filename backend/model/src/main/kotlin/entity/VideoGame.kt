package entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "video_games")
class VideoGame(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "description", nullable = true)
    var description: String?,

    @Column(name = "main_image", nullable = true)
    var mainImage: String?,

    @Column(name = "release_date", nullable = true)
    var releaseDate: Date?,

    @ManyToMany
    @JoinTable(
        name = "video_game_genre",
        joinColumns = [JoinColumn(name = "video_game_id")],
        inverseJoinColumns = [JoinColumn(name = "genre_id")]
    )
    @JsonManagedReference("video_game_genre")
    var genres: Set<Genre>?,

    @ManyToMany
    @JoinTable(
        name = "video_game_platform",
        joinColumns = [JoinColumn(name = "video_game_id")],
        inverseJoinColumns = [JoinColumn(name = "platform_id")]
    )
    @JsonManagedReference("video_game_platform")
    var platforms: Set<Platform>?,

    @ManyToOne
    @JoinColumn(name = "developer")
    @JsonManagedReference("video_game_company")
    var developer: Developer?,

    @OneToMany(mappedBy = "videoGame")
    @JsonManagedReference("video_game_video_game_user")
    var videoGameUsers: List<VideoGameUser>
)