package com.flatmate.service;

import com.flatmate.dto.MessageDTO;
import com.flatmate.entity.Message;
import com.flatmate.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final MessageRepository messageRepository;

    // ✅ GET MESSAGES
    public List<MessageDTO> getMessages(String matchId, Long userId) {

        List<Message> messages =
                messageRepository.findByMatchIdOrderByCreatedAtAsc(matchId);

        return messages.stream()
                .map(m -> new MessageDTO(
                        m.getSenderId(),   // ✅ FIXED
                        m.getContent()
                ))
                .collect(Collectors.toList());
    }

    // ✅ SEND MESSAGE
    public MessageDTO sendMessage(String matchId, Long senderId, String content) {

        Message message = new Message();

        message.setMatchId(matchId);   // ✅ String matchId
        message.setSenderId(senderId); // ✅ FIXED
        message.setContent(content);

        messageRepository.save(message);

        return new MessageDTO(senderId, content);
    }
}