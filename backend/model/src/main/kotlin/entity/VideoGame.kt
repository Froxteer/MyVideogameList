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
    @JsonManagedReference
    val genres: Set<Genre>?,

    @ManyToMany
    @JoinTable(
        name = "video_game_platform",
        joinColumns = [JoinColumn(name = "video_game_id")],
        inverseJoinColumns = [JoinColumn(name = "platform_id")]
    )
    @JsonManagedReference
    val platforms: Set<Platform>?,

    @ManyToMany
    @JoinTable(
        name = "video_game_company",
        joinColumns = [JoinColumn(name = "video_game_id")],
        inverseJoinColumns = [JoinColumn(name = "company_id")]
    )
    @JsonManagedReference
    val companies: Set<Company>?
)