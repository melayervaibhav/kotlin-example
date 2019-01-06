package demo.kotlinexample.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import demo.kotlinexample.domain.User
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.lang.NonNull
import java.util.*


@Repository
interface UserRepo : JpaRepository<User, Int> {
    /* ------------- START override jpaRepository methods formatted Code ---------------- */
//    override
//    fun findById(userId: Int): Optional<User>

    /* ------------- END override jpaRepository methods formatted Code ---------------- */

    /* ------------- START Native query formatted Code ---------------- */
    @Query("SELECT user_name FROM user", nativeQuery = true)
    fun retrieveAllUsername(): List<String>

//    @Query("SELECT * FROM user WHERE user_name = ?1", nativeQuery = true)
//    fun retrieveByUsername(userName: String): List<User>

    /* ------------- END Native query formatted Code ---------------- */

    /* ------------- START Non-native query formatted Code ---------------- */

    @Query("SELECT u FROM User u WHERE u.userName = ?1")
    fun retrieveByUsername(userName: String): List<User>

    @Query("SELECT u FROM User u")
    fun getAllUsersByASC(sort: Sort): List<User>


    /* ------------- END Non-native query formatted Code ---------------- */

}
