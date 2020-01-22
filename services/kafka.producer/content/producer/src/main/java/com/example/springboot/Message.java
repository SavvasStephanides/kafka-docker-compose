package com.example.springboot;


public class Message{
    private String body;

    public Message(){

    }

    public Message(String body){
        this.body = body;
    }

    public void setBody(String body){
        this.body = body;
    }

    public String getBody(){
        return this.body;
    }
}