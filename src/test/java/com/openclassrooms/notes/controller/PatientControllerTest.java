package com.openclassrooms.notes.controller;

import com.openclassrooms.notes.entity.Patient;
import com.openclassrooms.notes.service.PatientService;
import com.openclassrooms.notes.controller.PatientController;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PatientControllerTest {

    @InjectMocks
    private PatientController patientController;

    @Mock
    private PatientService patientService;

    private Patient patient;

    @BeforeEach
    public void setUp() {
        patient = new Patient("someId", 2L, new ArrayList<>()); // Initialize a Patient object
    }

    @Test
    public void testAddNote_Success() {
        String note = "New patient note";

        // Mock the behavior of the service
        when(patientService.updateNotes(2L, note)).thenReturn(patient);

        // Call the controller method
        Patient result = patientController.addNote(2L, note);

        // Verify the results
        assertNotNull(result);
        assertEquals(patient, result);
        verify(patientService, times(1)).updateNotes(2L, note);
    }

    @Test
    public void testAddNote_PatientNotFound() {
        String note = "New patient note";

        // Mock the behavior of the service to throw an exception
        when(patientService.updateNotes(2L, note)).thenThrow(new EntityNotFoundException("Patient not found with ID: 2"));

        // Call the controller method and expect an exception
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            patientController.addNote(2L, note);
        });

        // Verify the exception message
        assertEquals("Patient not found with ID: 2", exception.getMessage());
        verify(patientService, times(1)).updateNotes(2L, note);
    }
}