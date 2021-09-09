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
public class UserResults {
    private int u_id;
    private String name;
    private String uname;
    ArrayList<ExamQuestion> examQuestions;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public ArrayList<ExamQuestion> getExamQuestions() {
        return examQuestions;
    }

    public void setExamQuestions(ArrayList<ExamQuestion> examQuestions) {
        this.examQuestions = examQuestions;
    }
    
}
