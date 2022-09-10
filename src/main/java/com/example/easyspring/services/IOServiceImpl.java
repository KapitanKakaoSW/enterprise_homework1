package com.example.easyspring.services;

import com.example.easyspring.entities.PersonEntity;
import com.example.easyspring.utils.Constants;
import com.example.easyspring.utils.InputHandler;
import lombok.Setter;

import java.util.Scanner;

@Setter
public class IOServiceImpl implements IOService {

    private Scanner scanner;

    private PersonEntity personEntity;

    @Override
    public void takePersonData() {
        scanner = new Scanner(System.in);

        System.out.println(Constants.ENTER_NAME);
        personEntity.setName(InputHandler.nullDataHandler(scanner));

        System.out.println(Constants.ENTER_SURNAME);
        personEntity.setSurname(InputHandler.nullDataHandler(scanner));
    }

    @Override
    public void printResult(String result) {
        System.out.println(Constants.USER_DATA + personEntity.getName() + " " + personEntity.getSurname());
        System.out.println(Constants.RESULT_DESCRIPTION + result);
    }
}