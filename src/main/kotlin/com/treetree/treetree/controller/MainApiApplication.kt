package com.treetree.treetree.controller
import com.treetree.treetree.service.PeopleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/people/")
class MainApiApplication @Autowired constructor(val peopleService: PeopleService) {

    //url당 cnt 가져오기
    @GetMapping("/count")
    fun getCount(): CountResult {

        var getCnt = peopleService.getDataList()
        var cnt = 0;

        if(!getCnt.isEmpty()){
            cnt = getCnt.get(0).cnt
        }

        return CountResult(count = cnt)
    }


    data class CountResult(
            val count : Int,
    )

    //cnt 증가하기
    @PutMapping("/join")
    fun join(): JoinResult {

        val data = peopleService.updateData()

        return JoinResult(success = true)
    }

    data class JoinResult(
            val success: Boolean,
    )
}