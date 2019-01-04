package demo.kotlinexample.service

import demo.kotlinexample.domain.User
import demo.kotlinexample.repository.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepo:UserRepo) {
//    @Autowired(required = true)
//    lateinit var userRepo: UserRepo

    fun getAllUsernames(): List<String> {
        return userRepo.retrieveAllUsername()
    }

    fun saveUser(user: User): ResponseEntity<HashMap<String, String>> {
        val map = hashMapOf<String, String>()
        println("user requestBody ****************################## $user")
        val ab = userRepo.save(user)
        //        addressRepo.save(address)
        map["message"] = "saved"
        println("hiiiiiii" + ab.id)
        return ResponseEntity(
                map,
                HttpStatus.OK
        )
    }
    fun findByUsername(userName:String): List<User> {
        return this.userRepo.retrieveByUsername(userName)
    }
}