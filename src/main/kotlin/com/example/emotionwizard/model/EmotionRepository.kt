package com.example.emotionwizard.model

import com.example.emotionwizard.domain.EmotionBucket
import org.springframework.data.jpa.repository.JpaRepository

interface EmotionRepository : JpaRepository<EmotionBucket, Long> {

    fun findAllByUserId(userId : Long) : List<EmotionBucket>?

    fun findByIdAndUserId(id: Long, userId: Long) : EmotionBucket?
}