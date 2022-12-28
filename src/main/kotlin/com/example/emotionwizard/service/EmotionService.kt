package com.example.emotionwizard.service

import com.example.emotionwizard.domain.Emotion
import com.example.emotionwizard.domain.EmotionBucket
import com.example.emotionwizard.exception.NotFoundException
import com.example.emotionwizard.model.EmotionRepository
import com.example.emotionwizard.model.EmotionResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EmotionService(
    private val emotionRepository: EmotionRepository
) {

    @Transactional
    fun create(userId: Long, username: String, emotion: Emotion): EmotionResponse {
        val emotion = EmotionBucket(
            userId = userId,
            username = username,
            emotion = emotion,
        )
        return EmotionResponse(emotionRepository.save(emotion));
    }

    @Transactional(readOnly = true)
    fun getAll(userId: Long) =
        emotionRepository.findAllByUserId(userId)?.map { EmotionResponse(it) }


    @Transactional(readOnly = true)
    fun get(userId: Long, id: Long) : EmotionResponse {
        val emotionBucket = emotionRepository.findByIdAndUserId(id, userId)
            ?: throw NotFoundException("찾으시는 감정이 존재하지 않습니다.")

        return EmotionResponse(emotionBucket)
    }

    @Transactional
    fun delete(userId: Long, id: Long) {
        emotionRepository.findByIdAndUserId(id, userId)
            ?: throw NotFoundException("찾으시는 감정이 존재하지 않습니다.")

        emotionRepository.deleteById(id)
    }
}
