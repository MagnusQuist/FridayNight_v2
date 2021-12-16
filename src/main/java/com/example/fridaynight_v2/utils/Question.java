package com.example.fridaynight_v2.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {
    private String question;
    private ArrayList<String> answers = new ArrayList<>();
    private String correctAnswer;

    public Question(String question, String[] answers, int correct) {
        this.question = question;
        this.answers.addAll(Arrays.asList(answers));
        setCorrectAnswer(answers[correct]);
    }

    public void setCorrectAnswer(String answer) {
        this.correctAnswer = answer;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public String getQuestion() {
        return this.question;
    }
}
