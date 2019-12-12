/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.exos;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author utilisateur
 */
public class Questionnaire {

    final String FILE = this.getClass().getResource("/fty/exos/questions.lst").getPath();
    ArrayList<Question> list = new ArrayList();
    int score = 0;

    /**
     * Questionnaire 
     */
    public Questionnaire() {
        chargeListStatic();
        start();
        result();
    }

    /**
     * Pose une question et check le resultat
     * 
     * @param question
     * @return true si la reponse est correct
     */
    public boolean askQuestion(Question question) {
        Scanner kb = new Scanner(System.in);
        System.out.println(question.getQuestion());
        String answer = kb.nextLine();
        if(answer.equals(question.getAnswer())){
            return true;
        }
        return false;
    }
    
    /**
     * Affiche le score 
     */
    private void result(){
        System.out.println("Le score est de "+score);
    }
    
    private void saveQuestons(){
//        File file = new File(fileName);
//        BufferedReader in;
    }

    /**
     * Lance le questionnaire 
     */
    private void start() {
        for (Question q : list) {
            if(askQuestion(q)){
                score += q.getValue();
            }
        }
    }

    /**
     * Chargement statique du questionnaire 
     */
    private void chargeListStatic() {
        list.add(new Question("Quel langage à typage statique avez-vous vu en formation ?", "Java", 3));
        list.add(new Question("Quel IDE utilisez-vous ?", "IntelliJ", 1));
        list.add(new Question("Quel langage à typage dynamique avez-vous vu en formation ?", "Python", 2));
    }

    /**
     * Execute la class
     * @param args 
     */
    public static void main(String[] args) {
        new Questionnaire();
    }
}
