package com.example.emotionwizard.domain

enum class Emotion(val description: String, val category: String) {
    HAPPINESS("행복", "POSITIVE"),
    ACCOMPLISHMENT("성취감", "POSITVIE"),
    EXCITING("흥분됨", "POSITIVE"),
    FUN("즐거움", "POSITIVE"),
    FLUTTERED("설레임", "POSITIVE"),
    CONFIDENT("자신감", "POSITIVE"),
    LANGUOR("나른함", "NEUTRAL"),
    BORED("지루함", "NEUTRAL"),
    RELIEF("안도감", "NEUTRAL"),
    DISAPPOINTMENT("실망감", "NEGATIVE"),
    ANGER("화남", "NEGATIVE"),
    DEPRESSED("우울함", "NEGATIVE");
}