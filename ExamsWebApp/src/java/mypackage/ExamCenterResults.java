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
public class ExamCenterResults {
    private int ec_id;
    private String name;
    private String address;
    ArrayList<ExamResults> examResults = new ArrayList<>();

    public int getEc_id() {
        return ec_id;
    }

    public void setEc_id(int ec_id) {
        this.ec_id = ec_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<ExamResults> getExamResults() {
        return examResults;
    }

    public void setExamResults(ArrayList<ExamResults> examResults) {
        this.examResults = examResults;
    }
    
}
