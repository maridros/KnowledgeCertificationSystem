/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examsdesktopapp;

/**
 *
 * @author Maria
 */
public class UserBean extends PersonBean {
    private int u_id;
    private String name;
    private int ex_id;

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

    public int getEx_id() {
        return ex_id;
    }

    public void setEx_id(int ex_id) {
        this.ex_id = ex_id;
    }
    /*
    @Override
    public String toString() {
        return "User ID: " + u_id + " | Name: " + name + " | Username: " + this.getUname();

    }*/
    
}


