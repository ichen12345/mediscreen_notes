package com.openclassrooms.notes.service;

import com.openclassrooms.notes.entity.Patient;
import com.openclassrooms.notes.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient updateNotes(Long patientId, String newNote) {
        Patient original = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + patientId));

        String existingNotes = original.getNote();
        if (existingNotes == null || existingNotes.isEmpty()) {
            original.setNote(newNote);
        } else {
            original.setNote(existingNotes + "\n" + newNote);
        }

        return patientRepository.save(original);

    }
}
