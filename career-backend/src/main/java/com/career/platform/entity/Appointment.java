package com.career.platform.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long studentId;
    private String counselorName;
    private String topic;
    private String date;
    private String time;
    private String status; // SCHEDULED, COMPLETED, CANCELLED
}
