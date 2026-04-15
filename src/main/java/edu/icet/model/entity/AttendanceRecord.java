package edu.icet.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AttendanceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;      // උදා: "2026-03-25"
    private String status;    // "Present", "Absent", "Late"
    private String timeIn;    // "08:00 AM"
    private String timeOut;   // "02:00 PM"
    private String note;      // "Medical leave"
}