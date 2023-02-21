package com.treetree.treetree.controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/")
class MainApiApplication {

    @GetMapping("/test")
    fun readTodo(): String {
        return "Hello Todo4"
    }



}