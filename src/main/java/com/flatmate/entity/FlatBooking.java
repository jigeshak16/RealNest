package com.flatmate.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "flat_bookings")
public class FlatBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="flat_id")
    private Long flatId;

    @Column(name="user_id")
    private Long userId;

    @Column(name="booking_status")
    private String bookingStatus = "CONFIRMED";

    @Column(name="move_in_date")
    private LocalDate moveInDate;

    private String notes;

    public Long getId() { return id; }
    public Long getFlatId() { return flatId; }
    public Long getUserId() { return userId; }
    public String getBookingStatus() { return bookingStatus; }
    public LocalDate getMoveInDate() { return moveInDate; }
    public String getNotes() { return notes; }

    public void setId(Long id) { this.id = id; }
    public void setFlatId(Long flatId) { this.flatId = flatId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setBookingStatus(String bookingStatus) { this.bookingStatus = bookingStatus; }
    public void setMoveInDate(LocalDate moveInDate) { this.moveInDate = moveInDate; }
    public void setNotes(String notes) { this.notes = notes; }
}