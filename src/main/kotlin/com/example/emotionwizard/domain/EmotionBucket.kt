package com.example.emotionwizard.domain

import javax.persistence.*

@Table
@Entity
class EmotionBucket(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val userId: Long,

    @Column
    val username: String,

    @Column
    @Enumerated(EnumType.STRING)
    val emotion: Emotion,

    ) : BaseEntity()