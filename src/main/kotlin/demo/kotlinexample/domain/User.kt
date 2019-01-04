package demo.kotlinexample.domain

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class User(

        val userName: String? = null,
        val password: String? = null,
        val email: String? = null,
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int? = null
) {
        @JsonManagedReference
        @OneToMany(mappedBy = "userOne", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
        val address: Set<Address>? = emptySet()
}

