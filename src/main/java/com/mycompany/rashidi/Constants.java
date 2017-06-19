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
public class Constants {

    public static final int NUMBER_OF_QUESTIONS = 10;
    public static final int NUM_OF_USERS = 100;
    /**
     * minimum time a user can respond to a single question
     */
    public static final int MIN_RESPONSE_TIME = 15;
    /**
     * maximum response time a user can respond to a single question, 
     *
     */
    public static final int MAX_RESPONSE_TIME = 100;
    /**
     * 10 difficulties for 10 questions
     */
    public static final int[] DIFFICULTY = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    public static final int[] MAX_SCORES = {};
    public static final String[] REGIONS
            = {"REG1", "REG2", "REG3", "REG4", "REG5"};
    public static final int[] REGIONS_SENITIVITIES_FORM_1
            = {10, 20, 40, 60, 80};
    public static final int[] REGIONS_SENITIVITIES_FORM_2
            = {20, 10, 50, 70, 90};

    public static final String[] OPERATIONS
            = {"OP1", "OP2", "OP3", "OP4", "OP5", "OP6", "OP7"};
    public static final int[] OPERATION_SENITIVITIES
            = {10, 20, 30, 40, 50, 70, 90};

    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_MEDIUM = 2;
    public static final int PRIORITY_HIGH = 3;
    public static final int PRIORITY_SEVERITY = 4;
    public static final int[] QUESTION_PRIORITY = {Constants.PRIORITY_LOW,
        Constants.PRIORITY_LOW,
        Constants.PRIORITY_MEDIUM,
        Constants.PRIORITY_MEDIUM,
        Constants.PRIORITY_HIGH,
        Constants.PRIORITY_SEVERITY,
        Constants.PRIORITY_SEVERITY,
        Constants.PRIORITY_HIGH,
        Constants.PRIORITY_LOW,
        Constants.PRIORITY_HIGH};
}
