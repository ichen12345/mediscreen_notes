package com.openclassrooms.notes.repository;

import com.openclassrooms.notes.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, Long> {
    
}
