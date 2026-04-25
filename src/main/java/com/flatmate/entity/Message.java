package com.flatmate.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ CHANGED TO STRING
    @Column(name = "match_id")
    private String matchId;

    @Column(name = "sender_id")
    private Long senderId;

    private String content;

    @Column(name = "is_read")
    private Boolean isRead = false;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // TEMP FIELD FOR UI DISPLAY
    @Transient
    private String senderName;

    // GETTERS
    public Long getId() {
        return id;
    }

    public String getMatchId() {   // ✅ updated
        return matchId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public String getContent() {
        return content;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getSenderName() {
        return senderName;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setMatchId(String matchId) {   // ✅ updated
        this.matchId = matchId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
}