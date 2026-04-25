package com.flatmate.controller;

import com.flatmate.entity.Message;
import com.flatmate.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "*")
public class MessageController {

    @Autowired
    private MessageService service;

    // ✅ SEND MESSAGE
    @PostMapping("/send")
    public String sendMessage(@RequestBody Message message) {
        return service.sendMessage(message);
    }

    // ✅ LOAD CHAT BY MATCH ID (FIXED → String)
    @GetMapping("/{matchId}")
    public List<Message> getMessages(@PathVariable String matchId) {
        return service.getMessages(matchId);
    }

    // ✅ LOAD DASHBOARD INBOX
    @GetMapping("/inbox/{userId}")
    public List<Message> getInbox(@PathVariable Long userId) {
        return service.getInboxMessages(userId);
    }
}