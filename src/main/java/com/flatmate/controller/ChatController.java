package com.flatmate.controller;

import com.flatmate.dto.MessageDTO;
import com.flatmate.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ChatController {

    private final ChatService chatService;

    // ✅ GET MESSAGES
    @GetMapping("/{matchId}/messages")
    public List<MessageDTO> getMessages(
            @PathVariable String matchId,
            @RequestParam Long userId) {

        return chatService.getMessages(matchId, userId);
    }

    // ✅ SEND MESSAGE
    @PostMapping("/{matchId}/messages")
    public MessageDTO sendMessage(
            @PathVariable String matchId,
            @RequestBody Map<String, Object> request) {

        Long senderId = Long.valueOf(request.get("senderId").toString());
        String content = request.get("content").toString();

        return chatService.sendMessage(matchId, senderId, content);
    }
}