package service

import dao.UserDao
import entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired val userDao: UserDao) {

    fun saveUser(user: User) {
        val encoder = BCryptPasswordEncoder()

        user.password = encoder.encode(user.password)
        userDao.save(user)
    }

}