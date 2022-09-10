package com.example.easyspring.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionEntity {

    private String question;

    private String[] answers;

    private String correctAnswer;

    public QuestionEntity(String question, String[] answers, String correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }
}