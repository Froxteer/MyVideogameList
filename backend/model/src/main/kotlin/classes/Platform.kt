package classes

import java.sql.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "platforms")
class Platform(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "release_date", nullable = true)
    val releaseDate: Date?,

    // TODO developer OneToMany

    @ManyToMany
    val videoGames: Set<VideoGame>?
)