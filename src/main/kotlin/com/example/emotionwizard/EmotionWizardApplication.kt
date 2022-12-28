package com.example.emotionwizard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class EmotionWizardApplication

fun main(args: Array<String>) {
    runApplication<EmotionWizardApplication>(*args)
}
