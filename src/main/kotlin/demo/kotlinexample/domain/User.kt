package demo.kotlinexample.domain

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        public val id: Int? = null,
        public val userName: String? = null,
        public val password: String? = null,
        public val email: String? = null,
        @JsonManagedReference
        @OneToMany(mappedBy = "userOne", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
        public val address: Set<Address>?= emptySet()
)

