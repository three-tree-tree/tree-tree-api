package com.treetree.treetree.service

import com.treetree.treetree.model.People
import com.treetree.treetree.repository.PeopleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PeopleService @Autowired constructor(
    private val peopleRepository: PeopleRepository
) {
    fun updateData(): People {
        val post = peopleRepository.findById(1).get()
        post.cnt = post.cnt + 1
        return peopleRepository.save(post)
    }

    fun getDataList(): List<People> {
        return peopleRepository.findAll()
    }
}
