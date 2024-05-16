package com.openclassrooms.mediscreen.repository;

import com.openclassrooms.mediscreen.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
//    public List<Patient> findAll();
}
