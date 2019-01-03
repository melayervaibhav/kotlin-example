package demo.kotlinexample.repository

import demo.kotlinexample.domain.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepo: JpaRepository<Address, Int> {
}