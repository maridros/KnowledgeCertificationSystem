/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.util.ArrayList;

/**
 *
 * @author Maria
 */
public class ExamResults {
    private int ex_id;
    private String date;
    private String time;
    ArrayList<UserResults> userResults = new ArrayList<>();;

    public int getEx_id() {
        return ex_id;
    }

    public void setEx_id(int ex_id) {
        this.ex_id = ex_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<UserResults> getUserResults() {
        return userResults;
    }

    public void setUserResults(ArrayList<UserResults> userResults) {
        this.userResults = userResults;
    }
    
}
