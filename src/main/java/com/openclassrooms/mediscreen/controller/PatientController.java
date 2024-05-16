package com.openclassrooms.mediscreen.controller;

import com.openclassrooms.mediscreen.entity.Patient;
import com.openclassrooms.mediscreen.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping
    public List<Patient> findAll() {
        return patientService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public Patient create(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @PutMapping
    public Patient update(@RequestBody Patient patient) {
        return patientService.updatePatient(patient);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping
    public void delete(@RequestBody Patient patient) {
        patientService.deletePatient(patient);
    }

}
