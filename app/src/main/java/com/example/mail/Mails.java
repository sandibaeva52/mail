package com.example.mail;

import java.util.ArrayList;
import java.util.List;

public class Mails {
    private String name;
    private String description;
    private String time;


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time=time;
    }

    public Mails(String name, String description,String time){
        this.name=name;
        this.description=description;
        this.time=time;
    }


}
