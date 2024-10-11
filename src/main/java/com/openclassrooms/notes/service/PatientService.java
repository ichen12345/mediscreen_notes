package com.openclassrooms.notes.service;

import com.openclassrooms.notes.entity.Patient;

public interface PatientService {

    Patient updateNotes(Long patientId, String note);

}
