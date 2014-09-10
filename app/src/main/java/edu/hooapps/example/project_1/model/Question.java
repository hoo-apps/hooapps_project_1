package edu.hooapps.example.project_1.model;

/**
 * Model class to hold question information
 */
public class Question {

    // Question data
    private String questionText;
    private boolean answer;

    // Two argument constructor
    public Question(String questionText, boolean answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    // Accessors for the private fields
    public String getQuestionText() {
        return questionText;
    }

    public boolean getAnswer() {
        return answer;
    }
}