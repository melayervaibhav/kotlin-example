package demo.kotlinexample.controller

import org.springframework.http.ResponseEntity
import demo.kotlinexample.domain.User
import demo.kotlinexample.repository.AddressRepo
import demo.kotlinexample.repository.UserRepo
import demo.kotlinexample.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class UserController(
        private val userRepo: UserRepo,
        private val addressRepo: AddressRepo
) {
    @Autowired(required = true)
    lateinit var userService: UserService

    @PostMapping("/addUser")
    fun addUser(@RequestBody user: User): ResponseEntity<HashMap<String, String>> {

        return this.userService.saveUser(user)
    }

    @GetMapping("/getUserDetailByUsername")
    fun findByUsername(@RequestParam userName: String): Map<String, Any> {
        val user = this.userService.findByUsername(userName)
        return mapOf("msg" to "Success", "result" to user)
    }

    @GetMapping("/getAllUsername")
    fun getAllUsernameList(): Map<String, Any> {
        val usernameList = this.userService.getAllUsernames()
        return mapOf("msg" to "Success", "result" to usernameList)
    }

    @GetMapping("/getUserDetailById")
    fun getAllUsers(@RequestParam userId: Int) {
    }
}
