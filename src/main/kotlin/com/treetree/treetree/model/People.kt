package com.treetree.treetree.model
import com.treetree.treetree.dto.PeopleFromDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class People (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var cnt: Int //cnt
    ) {

        fun updatePost(peopleFormDto: PeopleFromDto) { //cnt update
            cnt = peopleFormDto.cnt+1
            id = 1
        }
    }