package demo.kotlinexample.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Address(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,
        val city: String? = null,
        val state: String? = null
){
        @JsonBackReference
        @ManyToOne( cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        val userOne: User? = null
}