package entity

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    @Column(name = "email", nullable = false)
    var email: String,

    @Column(name = "username", nullable = false)
    var username: String,

    @Column(name = "password", nullable = false)
    var password: String,

    @OneToMany(mappedBy = "user")
    @JsonBackReference("user_video_game_user")
    var videoGameUsers: List<VideoGameUser>
)