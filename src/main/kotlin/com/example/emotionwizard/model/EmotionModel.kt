package com.example.emotionwizard.model

import com.example.emotionwizard.domain.Emotion
import com.example.emotionwizard.domain.EmotionBucket
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class EmotionRequest(
    val emotion: Emotion,
)

data class EmotionResponse(
    val id: Long,
    val userId: Long,
    val username: String,
    val emotion: Emotion,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime?,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val updatedAt: LocalDateTime?,
) {
    companion object {
        operator fun invoke(emotionBucket: EmotionBucket) =
            with(emotionBucket) {
                EmotionResponse(
                    id = id!!,
                    userId = userId,
                    username = username,
                    emotion = emotion,
                    createdAt = createdAt,
                    updatedAt = updatedAt
                )
            }
    }
}