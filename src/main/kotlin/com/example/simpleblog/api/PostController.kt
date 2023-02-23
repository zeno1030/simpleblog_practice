package com.example.simpleblog.api

import com.example.simpleblog.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class PostController(
    private val postService: PostService
) {
    @GetMapping("/posts")
    fun findPosts(): CmResDto<HttpStatus>{
        return CmResDto(HttpStatus.OK, "find posts", postService.findPosts())
    }
}