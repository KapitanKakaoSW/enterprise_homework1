package com.example.easyspring.dao;

import com.example.easyspring.entities.QuestionEntity;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
public class QuestionsDAO {

    private ClassPathResource resource;

    public List<QuestionEntity> loadQuestions() throws IOException {

        List<QuestionEntity> questions = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

        reader.lines().map(line -> line.split(";")).forEachOrdered(elements -> {
            String[] answers = Arrays.copyOfRange(elements, 1, elements.length - 1);
            questions.add(new QuestionEntity(elements[0], answers, elements[elements.length - 1]));
        });
        return questions;
    }
}
