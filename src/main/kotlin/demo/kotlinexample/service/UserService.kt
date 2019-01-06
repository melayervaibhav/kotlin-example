package demo.kotlinexample.service

import com.sun.deploy.net.HttpResponse
import demo.kotlinexample.domain.User
import demo.kotlinexample.repository.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.http.HttpMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepo: UserRepo) {
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

    fun findByUsername(userName: String): List<User> {
        return this.userRepo.retrieveByUsername(userName)
    }

    fun getUserOfGreatestId(position: Int): Map<String, Any> {
        var userByASC = userRepo.getAllUsersByASC(Sort(Sort.Direction.ASC, "id"))
        return mapOf("msg" to HttpStatus.OK, "result" to userByASC.get(userByASC.size - position))
    }

    fun sortUser(propertyName: String, sortOrder: String): Map<String, Any> {
        return when (sortOrder) {
            "ASC" -> {
                val userList = userRepo.getAllUsersByASC(Sort(Sort.Direction.ASC, "$propertyName"))
                mapOf("msg" to HttpStatus.OK, "result" to userList)
            }
            "DESC" -> {
                val userList = userRepo.getAllUsersByASC(Sort(Sort.Direction.DESC, "$propertyName"))
                mapOf("msg" to HttpStatus.OK, "result" to userList)
            }
            else -> {
                mapOf("mag" to "Sort order value is wrong", "result" to emptyList<User>())
            }
        }
    }
}