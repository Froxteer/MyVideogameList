package service

import dao.UserDao
import entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired val userDao: UserDao) {

    fun saveUser(user: User): User {
        val encoder = BCryptPasswordEncoder()

        user.password = encoder.encode(user.password)
        return userDao.save(user)
    }

    fun logIn(username: String, password: String): User {
        val user = userDao.getByUsername(username)
        val encoder = BCryptPasswordEncoder()

        return if (encoder.matches(password, user.password)) user
        else throw Exception("Password doesn't match")
    }

}