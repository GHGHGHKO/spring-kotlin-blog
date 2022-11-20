package me.synology.kotlinblog.service

import me.synology.kotlinblog.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(
    private val userRepository: UserRepository) {

    fun findOne(login: String) =
        userRepository.findByLogin(login) ?: throw
        ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist")
}