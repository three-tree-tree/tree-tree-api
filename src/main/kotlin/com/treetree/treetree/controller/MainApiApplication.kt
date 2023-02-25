package com.treetree.treetree.controller

import com.treetree.treetree.service.PeopleService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])
class MainApiApplication(
    private val peopleService: PeopleService
) {
    // url당 cnt 가져오기
    @GetMapping("people/count")
    fun getCount(): CountResult {
        val getCnt = peopleService.getDataList()

        val cnt = if (getCnt.isEmpty()) {
            0
        } else {
            getCnt.first().cnt
        }

        return CountResult(count = cnt)
    }

    data class CountResult(
        val count: Int
    )

    // cnt 증가하기
    @PutMapping("people/join")
    fun join(): JoinResult {
        peopleService.updateData()
        return JoinResult(success = true)
    }

    data class JoinResult(
        val success: Boolean
    )

    @GetMapping(".well-known/acme-challenge/AHYq48_GTBu3uXzoKzSjWC9RSfQphLd5mEjiVfZMAns")
    fun cert(): String {
        return "AHYq48_GTBu3uXzoKzSjWC9RSfQphLd5mEjiVfZMAns.ofrzhGihE4RkXTflExk0lLzBzcd0gZ3EvUq0VkFU1Vk"
    }
}
