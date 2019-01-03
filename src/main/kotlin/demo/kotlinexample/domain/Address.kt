package demo.kotlinexample.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Address(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public val id: Int? = null,
        public val city: String? = null,
        public val state: String? = null,
        @JsonBackReference
        @ManyToOne(cascade = [(CascadeType.ALL)])
        @JoinColumn(name = "user_id")
        public val userOne: User? = null

)