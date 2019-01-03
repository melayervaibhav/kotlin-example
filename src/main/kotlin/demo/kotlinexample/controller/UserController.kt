package demo.kotlinexample.controller

import demo.kotlinexample.domain.Address
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import demo.kotlinexample.domain.User
import demo.kotlinexample.repository.AddressRepo
import demo.kotlinexample.repository.UserRepo


@RestController
class UserController(
        private val userRepo: UserRepo,
        private val addressRepo: AddressRepo
) {


    //    var map: Map<String, Object> = hashMapOf()
    @PostMapping("/addUser")
    fun addUser(@RequestBody user: User): ResponseEntity<HashMap<String, String>> {
        var map: HashMap<String, String> = hashMapOf<String, String>()
        /*val newUser =*/
        var ab = userRepo.save(user)
//        addressRepo.save(address)
        map.put("message", "saved");
        println("hiiiiiii" + ab.id)
        val entity = ResponseEntity(map, HttpStatus.OK)
        return entity;
    }
}
