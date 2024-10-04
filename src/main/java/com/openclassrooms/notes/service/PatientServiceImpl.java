package com.openclassrooms.notes.service;

import com.openclassrooms.notes.entity.Patient;
import com.openclassrooms.notes.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient updateNotes(Patient patient) {
        Patient original = patientRepository.findById(patient.getPatientId()).orElse(null);
        original.setNote(patient.getNote());

        return original;

    }
}
