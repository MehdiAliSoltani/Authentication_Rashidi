/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rashidi;

/**
 *
 * @author mehdi
 */
public class User {
    private int userid;
    Question[] question;

    public User(int userid, Question[] question) {
        this.userid = userid;
        this.question = question;
    }

    public int getUserid() {
        return userid;
    }

    public Question[] getQuestion() {
        return question;
    }

   
    
    
    
}
