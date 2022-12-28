package com.example.emotionwizard.web

import com.example.emotionwizard.config.AuthUser
import com.example.emotionwizard.model.EmotionRequest
import com.example.emotionwizard.service.EmotionService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/emotion")
class EmotionController(
    private val emotionService: EmotionService
) {

    @PostMapping
    fun creat(
        authUser: AuthUser,
        @RequestBody request: EmotionRequest,
    ) = emotionService.create(authUser.userId, authUser.username, request.emotion)

    @GetMapping
    fun getAll(
        authUser: AuthUser,
    ) = emotionService.getAll(authUser.userId)

    @GetMapping("/{id}")
    fun get(
        authUser: AuthUser,
        @PathVariable id: Long,
    ) = emotionService.get(authUser.userId, id)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        authUser: AuthUser,
        @PathVariable id: Long,
    ) = emotionService.delete(authUser.userId, id)
}