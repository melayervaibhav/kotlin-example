package demo.kotlinexample.domain

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int? = null,
        val userName: String? = null,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        val password: String? = null,
        val email: String? = null

) {

        @OneToMany(mappedBy = "userOne", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
        val address: Set<Address>? = emptySet()
}

