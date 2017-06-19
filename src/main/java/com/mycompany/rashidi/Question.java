/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rashidi;

import java.io.Serializable;

/**
 *
 * @author mehdi
 */
public class Question implements Serializable{
    private int qId;
    private String qname;
    private int difficulty; 
    private int score;
    private int timeToResponce;
    private int priority;
    private boolean answer;

    public Question(int qId, String qname, int difficulty, int score, int timeToResponce, int priority) {
        this.qId = qId;
        this.qname = qname;
        this.difficulty = difficulty;
        this.score = score;
        this.timeToResponce = timeToResponce;
        this.priority = priority;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getqId() {
        return qId;
    }

    public String getQname() {
        return qname;
    }

    public int getTimeToResponce() {
        return timeToResponce;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

   
    
}
