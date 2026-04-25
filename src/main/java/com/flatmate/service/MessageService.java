package com.flatmate.service;

import com.flatmate.entity.Message;
import com.flatmate.entity.User;
import com.flatmate.repository.MessageRepository;
import com.flatmate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    @Autowired
    private UserRepository userRepository;

    // ✅ SEND MESSAGE
    public String sendMessage(Message message) {
        repository.save(message);
        return "Message sent";
    }

    // ✅ LOAD CHAT BY MATCH ID (FIXED → String)
    public List<Message> getMessages(String matchId) {

        List<Message> messages =
                repository.findByMatchIdOrderByCreatedAtAsc(matchId);

        for (Message msg : messages) {
            User user = userRepository
                    .findById(msg.getSenderId())
                    .orElse(null);

            if (user != null) {
                msg.setSenderName(user.getFullName());
            }
        }

        return messages;
    }

    // ✅ LOAD DASHBOARD INBOX
    public List<Message> getInboxMessages(Long userId) {

        List<Message> messages =
                repository.findBySenderIdNot(userId);

        for (Message msg : messages) {
            User user = userRepository
                    .findById(msg.getSenderId())
                    .orElse(null);

            if (user != null) {
                msg.setSenderName(user.getFullName());
            }
        }

        return messages;
    }
}