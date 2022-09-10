package com.example.easyspring;

import com.example.easyspring.services.IOServiceImpl;
import com.example.easyspring.services.QuizServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class EasySpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        IOServiceImpl ioServiceImpl = (IOServiceImpl) context.getBean("ioServiceImpl");
        QuizServiceImpl quizServiceImpl = (QuizServiceImpl) context.getBean("quizServiceImpl");

        ioServiceImpl.takePersonData();
        quizServiceImpl.executeQuiz();
    }
}
