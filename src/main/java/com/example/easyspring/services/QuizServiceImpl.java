package com.example.easyspring.services;

import com.example.easyspring.dao.QuestionsDAO;
import com.example.easyspring.entities.QuestionEntity;
import com.example.easyspring.utils.Constants;
import com.example.easyspring.utils.InputHandler;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.*;

@Setter
public class QuizServiceImpl implements QuizService {

    private QuestionsDAO questionsDAO;

    private IOServiceImpl ioServiceImpl;

    private List<QuestionEntity> questionEntities;

    private int score;

    @Override
    @SneakyThrows
    public void executeQuiz() {
        questionEntities = questionsDAO.loadQuestions();

        int questionNumber = 0;
        Scanner scanner = new Scanner(System.in);

        while (questionNumber < questionEntities.size()) {
            System.out.println(questionEntities.get(questionNumber).getQuestion());
            System.out.println(Constants.QUIZ_MESSAGE_INPUT);

            int answerNumber = 1;
            for (String answer : questionEntities.get(questionNumber).getAnswers()) {
                System.out.println(answerNumber + ")" + answer);
                answerNumber++;
            }

            String answer = InputHandler.answerHandler(scanner);
            scoring(questionNumber, answer);
            questionNumber++;
        }
        ioServiceImpl.printResult(score + "/" + questionNumber);
    }

    @Override
    public void scoring(int number, String answer) {
        if (questionEntities.get(number).getCorrectAnswer().trim().equalsIgnoreCase(answer)) {
            score++;
        }
    }
}