package com.openclassrooms.notes.service;

import com.openclassrooms.notes.entity.Patient;
import com.openclassrooms.notes.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{
    private static final Logger log = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient updateNotes(Long patId, String newNote) {
        // Retrieve the patient by ID
        Patient original = patientRepository.findByPatId(patId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + patId));

        // Check if the patient already has notes, and if so, add the new note to the list
        if (original.getNote() == null) {
            original.setNote(new ArrayList<>());  // Initialize the list if it's null
        }
        original.getNote().add(newNote);  // Add the new note
        log.info("Patient updated: " + original);
        // Save the updated patient object
        return patientRepository.save(original);
    }


    @Override
    public Patient findAPatient(Long patId) {
        Optional<Patient> patientOpt = patientRepository.findByPatId(patId);
        if (patientOpt.isEmpty()) {
            System.out.println("Patient with patId " + patId + " not found in the database.");
        }
        return patientOpt.orElseThrow(() -> new EntityNotFoundException("Patient not found"));
    }

    @Override
    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }
}
