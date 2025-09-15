package com.example.messageendpoint.repository;

import com.example.messageendpoint.model.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
// Repository-klassen fungerer som et datalager i hukommelsen.
// Den opretter 3 beskeder ved opstart og returnerer dem via en metode
public class MessageRepository {
    private final List<Message> messages = new ArrayList<>();
    private int messageId = 1;

    public MessageRepository() {
        populateMessages();
    }

    private void populateMessages() {
        while (messageId <= 3) {
            messages.add(new Message(messageId, "Velkommen til " + messageId + ".semester"));
            messageId++;
        }
    }

    public List<Message> getAllMessages() {
        return messages;
    }

    public Message findMessageById(int id) {
        for (Message message : messages) {
            if (message.getId() == id) {
                return message;
            }
        }
        return null;
    }

    public void addMessage(Message message) {
        int id = 1;
        for (Message msg : messages) {
            id++;
        }
        message.setContent(message.getContent());
        message.setId(id);
        messages.add(message);
    }

}