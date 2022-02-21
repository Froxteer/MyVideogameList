package classes

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "video_games")
class VideoGame(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "title", nullable = false)
    val title: String,

    @Column(name = "release_date", nullable = true)
    val releaseDate: Date?,

    @ManyToMany
    @JoinTable(
        name = "video_game_genre",
        joinColumns = [JoinColumn(name = "video_game_id")],
        inverseJoinColumns = [JoinColumn(name = "genre_id")]
    )
    val genres: Set<Genre>?
)