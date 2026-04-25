package com.flatmate.repository;

import com.flatmate.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository
        extends JpaRepository<Message, Long> {

    // ✅ FIXED: use String instead of Long
    List<Message> findByMatchId(String matchId);

    // ✅ NEW: ordered messages (VERY IMPORTANT for chat UI)
    List<Message> findByMatchIdOrderByCreatedAtAsc(String matchId);

    // existing
    List<Message> findBySenderIdNot(Long senderId);
}