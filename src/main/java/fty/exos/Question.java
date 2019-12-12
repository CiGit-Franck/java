/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.exos;

import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author utilisateur
 */
public class Question {

    private String question;
    private String answer;
    private int value;

    public Question(String question, String answer, int value) {
        this.question = question;
        this.answer = answer;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[DEBUT]\n"
                + question + "\n"
                + answer + "\n"
                + value + "\n"
                + "[FIN]\n";
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
