package com.example.messageendpoint.service;

import com.example.messageendpoint.model.Message;
import com.example.messageendpoint.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Service-laget indeholder forretningslogik og kalder repository-klassen.
// Repository injiceres via konstruktøren (dependency injection).
public class MessageService {
    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public List<Message> getMessages() {
        return repository.getAllMessages();
    }

    public Message findMessageById(int id, String caps) {
        Message message = repository.findMessageById(id);
        if (caps != null && caps.equals("yes")) {
            return new Message(message.getId(), message.getContent().toUpperCase());
        }
        return message;
    }
    public Message addMessage(Message message) {
        repository.addMessage(message);
        return  message;
    }
}