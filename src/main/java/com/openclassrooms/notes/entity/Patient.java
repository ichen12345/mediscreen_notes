package com.openclassrooms.notes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
public class Patient {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//     get id from the first microservice
    @Id
    private Long id;

    @Column
    private Long patId;

    public Patient(Long patId, List<String> note) {
        this.patId = patId;
        this.note = note;
    }

    @Column
    private List<String> note;

}
