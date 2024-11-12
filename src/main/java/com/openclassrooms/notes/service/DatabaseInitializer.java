package com.openclassrooms.notes.service;

import com.openclassrooms.notes.entity.Patient;
import com.openclassrooms.notes.repository.PatientRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseInitializer {

    @Autowired
    private PatientRepository patientRepository;

    @PostConstruct
    public void init() {
        // Check if the database already contains data to avoid duplicate inserts
        if (patientRepository.count() == 0) {
            // Initial data
            List<String> notes1 = new ArrayList<>();
            notes1.add("Patient: TestNone Practitioner's notes/recommendations: Patient states that they are 'feeling terrific'. Weight at or below recommended level.");
            Patient p1 = new Patient(1L, notes1);

            List<String> notes2 = new ArrayList<>();
            notes2.add("Patient: TestBorderline Practitioner's notes/recommendations: Patient states that they are feeling a great deal of stress at work. Patient also complains that their hearing seems abnormal as of late.");
            Patient p2 = new Patient(2L, notes2);

            List<String> notes3 = new ArrayList<>();
            notes3.add("Patient: TestInDanger Practitioner's notes/recommendations: Patient states that they are short term Smoker");
            notes3.add("Patient: TestInDanger Practitioner's notes/recommendations: Patient states that they quit within last year Patient also complains that of Abnormal breathing spells Lab reports Cholesterol LDL high");
            Patient p3 = new Patient(3L, notes3);

            List<String> notes4 = new ArrayList<>();
            notes4.add("Patient: TestEarlyOnset Practitioner's notes/recommendations: Patient states that walking up stairs has become difficult Patient also complains that they are having shortness of breath Lab results indicate Antibodies present elevated Reaction to medication");
            notes4.add("Patient: TestEarlyOnset Practitioner's notes/recommendations: Patient states that they are experiencing back pain when seated for a long time");
            notes4.add("Patient: TestEarlyOnset Practitioner's notes/recommendations: Patient states that they are a short term Smoker Hemoglobin A1C above recommended level");
            notes4.add("Patient: TestEarlyOnset Practitioner's notes/recommendations: Patient states that Body Height, Body Weight, Cholesterol, Dizziness and Reaction");
            Patient p4 = new Patient(4L, notes4);

            patientRepository.deleteAll(); // Clear the existing data
            patientRepository.insert(p1);
            patientRepository.insert(p2);
            patientRepository.insert(p3);
            patientRepository.insert(p4);
        }
    }
}
