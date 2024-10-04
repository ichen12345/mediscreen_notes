package com.openclassrooms.notes.entity;

import jakarta.persistence.*;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Patient {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//     get id from the first microservice
    @Id
    private Long patientId;
    @Column
    private String note;

    public Patient(String note) {
        this.note = note;
    }
}
