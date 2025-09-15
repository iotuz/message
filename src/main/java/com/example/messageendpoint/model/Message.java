package com.example.messageendpoint.model;

// Model-klassen der repræsenterer en besked.
// Den indeholder to felter: id og content, samt en konstruktør og getters.
public class Message {
    private int id;
    private String content;

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }


}