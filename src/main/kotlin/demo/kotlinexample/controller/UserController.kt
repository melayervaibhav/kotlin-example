package demo.kotlinexample.controller

import org.springframework.http.ResponseEntity
import demo.kotlinexample.domain.User
import demo.kotlinexample.repository.AddressRepo
import demo.kotlinexample.repository.UserRepo
import demo.kotlinexample.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import kotlin.text.Typography.greater


@RestController
class UserController(
        private val userRepo: UserRepo,
        private val addressRepo: AddressRepo
) {
    @Autowired()
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
    fun getAllUsers(@RequestParam userId: Int): Map<String, Any> {
        val user = userRepo.findById(userId)
        println("000000000000------------ $user");
        return mapOf("msg" to "success", "result" to user)
    }
    @GetMapping("/getUserAtPositionOfGreatestId")
    fun getAllUsersByASC(@RequestParam position:Int): Map<String, Any> {
        return this.userService.getUserOfGreatestId(position)
    }
    @GetMapping("getSortedUserListByField")
    fun getSortedUserListByField(@RequestParam field:String, @RequestParam sortOrder:String): Map<String, Any> {
        return this.userService.sortUser(field, sortOrder)
    }
}
