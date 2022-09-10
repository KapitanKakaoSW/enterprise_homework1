package com.example.easyspring.services;

public interface QuizService {

    void executeQuiz();

    void scoring(int number, String answer);
}