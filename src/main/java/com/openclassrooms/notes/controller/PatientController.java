package com.openclassrooms.notes.controller;

import com.openclassrooms.notes.entity.Patient;
import com.openclassrooms.notes.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class PatientController {
    @Autowired
    PatientService patientService;

    @PutMapping
    public Patient updateNotes(@RequestBody Patient patient) {
        return patientService.updateNotes(patient);
    }


}
