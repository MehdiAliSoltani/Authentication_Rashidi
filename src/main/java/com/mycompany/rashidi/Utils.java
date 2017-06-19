/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rashidi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mehdi
 */
public class Utils {

    public User[] createUsers() {
        User[] users = new User[Constants.NUM_OF_USERS];

        for (int index = 0; index < Constants.NUM_OF_USERS; index++) {
            System.out.println("User " + index);
            Question[] questions = createQuestions();
//            for(Question q :questions){
//                System.out.println(q.getqId() + "  "+ q.getQname()+ "  Diff ="+ q.getDifficulty()+ "  PR ="+ q.getPriority()+ "  Score ="+ q.getScore());
//            }
            System.out.println("------------------------------------");
            updateScores(questions);
            for (Question q : questions) {
                System.out.println(q.getqId() + "  " + q.getQname() + "  Diff =" + q.getDifficulty() + "  PR =" + q.getPriority() + "  Score =" + q.getScore());
            }

            users[index] = new User(index, questions);
        }

        List<List<String>> list = new ArrayList<List<String>>();
        for (User user : users) {
            List<String> us = new ArrayList<String>();
            us.add("" + user.getUserid());
            for (Question q : user.getQuestion()) {
                us.add("" + q.getqId());
                us.add(q.getQname());
                us.add("" + q.getTimeToResponce());
                us.add("" + q.getDifficulty());
                us.add("" + q.getPriority());
                us.add("" + q.getScore());

            }
            list.add(us);

        }
        WriteExcelFile writeExcel = new WriteExcelFile();
        writeExcel.writeListToExcel(list);

        return users;
    }

    private void updateScores(Question[] questions) {
        int sumOfDiff_Mul_Pr = 0;
        for (Question quest : questions) {
            sumOfDiff_Mul_Pr = sumOfDiff_Mul_Pr + (quest.getDifficulty() * quest.getPriority());
//            sumOfDiff_Mul_Pr = sumOfDiff_Mul_Pr + (quest.getDifficulty() );
        }
        for (Question quest : questions) {
            quest.setScore(quest.getPriority()
                    * //                    Math.round(sumOfDiff_Mul_Pr / (quest.getDifficulty() * quest.getPriority())));
                    Math.round(sumOfDiff_Mul_Pr / (quest.getDifficulty())));
        }
    }

    private Question[] createQuestions() {
        Question[] questions = new Question[Constants.NUMBER_OF_QUESTIONS];
        for (int i = 0; i < Constants.NUMBER_OF_QUESTIONS; i++) {
            String qName = "q" + i;
//            System.out.println(i);
            int responseTime = getResponseTime(i);
            int difficulty = getDifficulty(responseTime);
            int priority = getQuestionPriority(i);
            int score = 0;
            questions[i] = new Question(i, qName, difficulty, score, responseTime, priority);
//            questions[i].setAnswer(false);
        }
        return questions;
    }

    /**
     * Returns difficulty based on the time a user respond to a question
     *
     * @param resposeTime
     * @return
     */
    private int getDifficulty(int resposeTime) {
        int difficulty = Constants.DIFFICULTY[9];
        if (resposeTime > 10 && resposeTime <= 20) {
            difficulty = Constants.DIFFICULTY[0];
        } else if (resposeTime > 20 && resposeTime <= 30) {
            difficulty = Constants.DIFFICULTY[1];
        } else if (resposeTime > 30 && resposeTime <= 40) {
            difficulty = Constants.DIFFICULTY[2];
        } else if (resposeTime > 40 && resposeTime <= 50) {
            difficulty = Constants.DIFFICULTY[3];
        } else if (resposeTime > 50 && resposeTime <= 60) {
            difficulty = Constants.DIFFICULTY[4];
        } else if (resposeTime > 60 && resposeTime <= 70) {
            difficulty = Constants.DIFFICULTY[5];
        } else if (resposeTime > 70 && resposeTime <= 80) {
            difficulty = Constants.DIFFICULTY[6];
        } else if (resposeTime > 80 && resposeTime <= 90) {
            difficulty = Constants.DIFFICULTY[7];
        } else if (resposeTime > 90 && resposeTime <= 100) {
            difficulty = Constants.DIFFICULTY[8];
        }
//        return difficulty;
        return resposeTime;
    }

    /**
     * Timer: this method calculate a response time a user respond to a
     * question. we use a MAX RESPONSE TIME as a threshold of response time. we
     * also assume question difficulty increases randomly from Q1 to Q10
     *
     * @param questionNo
     * @return
     */
    private int getResponseTime(int questionNo) {
        int max = Constants.MAX_RESPONSE_TIME;
        Random random = new Random();
        int responseTime = 0;
        questionNo++;
//        System.out.println("questionNo =" + questionNo);
        switch (questionNo) {
            case 1:
                responseTime = random.nextInt((int) (max * 0.1));
                break;
            case 2:
                responseTime = random.nextInt((int) (max * 0.2));
                break;
            case 3:
                responseTime = random.nextInt((int) (max * 0.3));
                break;
            case 4:
                responseTime = random.nextInt((int) (max * 0.4));
                break;
            case 5:
                responseTime = random.nextInt((int) (max * 0.5));
                break;
            case 6:
                responseTime = random.nextInt((int) (max * 0.6));
                break;
            case 7:
                responseTime = random.nextInt((int) (max * 0.7));
                break;
            case 8:
                responseTime = random.nextInt((int) (max * 0.8));
                break;
            case 9:
                responseTime = random.nextInt((int) (max * 0.9));
                break;
            case 10:
                responseTime = random.nextInt(max);
                break;
            default:
                System.out.println("ERROR = " + questionNo);
                throw new AssertionError();
        }
        if (responseTime < Constants.MIN_RESPONSE_TIME) {
            return responseTime + Constants.MIN_RESPONSE_TIME;
        }

        return responseTime;
    }

    private int getQuestionPriority(int qId) {
        return Constants.QUESTION_PRIORITY[qId];
    }

    public static void main(String[] args) {

        Utils util = new Utils();
        User[] u = util.createUsers();
        /*       for (int i = 0; i < 100; i++) {
            int qno = i % 10;
            if (qno == 0) {
                qno = 10;
            }
            System.out.println("Q NO = " + qno + "  " + util.getResponseTime(qno));
        }*/
    }
}
