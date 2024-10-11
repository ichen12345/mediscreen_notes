package com.openclassrooms.notes.controller;

import com.openclassrooms.notes.entity.Patient;
import com.openclassrooms.notes.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patHistory")
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK) // You can change this based on your requirements
    public Patient addNote(@RequestParam Long patId, @RequestParam String note) {
        return patientService.updateNotes(patId, note);
    }


}
