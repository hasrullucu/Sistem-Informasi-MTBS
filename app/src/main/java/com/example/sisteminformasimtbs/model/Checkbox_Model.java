package com.example.sisteminformasimtbs.model;

public class Checkbox_Model {
    private boolean status_Check;
    private String text_Checkbox ;
    private int id;


    public Checkbox_Model(String text_Checkbox , int id){
        this.text_Checkbox = text_Checkbox;
        this.status_Check = false;
        this.id = id ;
    }

    public boolean isStatus_Check() {
        return status_Check;
    }

    public void setStatus_Check(boolean status_Check) {
        this.status_Check = status_Check;
    }

    public String getText_Checkbox() {
        return text_Checkbox;
    }

    public void setText_Checkbox(String text_Checkbox) {
        this.text_Checkbox = text_Checkbox;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
