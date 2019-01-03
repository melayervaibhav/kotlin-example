package demo.kotlinexample.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import demo.kotlinexample.domain.User


@Repository
interface UserRepo: JpaRepository<User, Int> {


}
