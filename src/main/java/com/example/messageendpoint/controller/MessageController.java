package com.example.messageendpoint.controller;


import com.example.messageendpoint.model.Message;
import com.example.messageendpoint.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;



@Controller
@RequestMapping("message")
// Controller-klassen håndterer HTTP-anmodninger fra klienten.
// Den bruger @Controller i stedet for @RestController og returnerer data via ResponseEntity.
public class MessageController {
    private final MessageService service;

    public MessageController(MessageService messageService) {
        this.service = messageService;
    }

    @GetMapping()
    public ResponseEntity<List<Message>> getMessages() {
        List<Message> messages = service.getMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable int id, @RequestParam(required = false) String caps) {

        Message message = service.findMessageById(id, caps);

        if (message != null) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/add")
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        Message messageSend = service.addMessage(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


    @GetMapping("view")
    public String showAllPage(Model model) {
        String msg = "";
        for (Message message : service.getMessages()) {
            msg += message.getId() + message.getContent();
        }
        model.addAttribute("list", msg);
        return "index";
    }




}