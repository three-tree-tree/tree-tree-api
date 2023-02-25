package com.treetree.treetree.service
import com.treetree.treetree.dto.PeopleFromDto
import com.treetree.treetree.model.People
import com.treetree.treetree.repository.PeopleRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PeopleService @Autowired constructor(
        val peopleRepository: PeopleRepository,
        val modelMapper: ModelMapper
) {

    fun save(peopleFormDto: PeopleFromDto): Long? {
        return peopleRepository.save(modelMapper.map(peopleFormDto, People::class.java)).id
    }

    fun getData(id: Long): People? {
        return peopleRepository.findById(id).get()
    }

    fun updateData(): People {
        val post = peopleRepository.findById(1).get()
//        post.updatePost(peopleFormDto)
//        peopleFormDto.id = 1
        post.cnt = post.cnt+1

        return peopleRepository.save(post)
    }

    fun getDataList(): List<People> {
        return peopleRepository.findAll()
    }

}