package com.openclassrooms.notes;

import com.openclassrooms.notes.entity.Patient;
import com.openclassrooms.notes.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class NotesApplication {

	private static final Logger log = LoggerFactory.getLogger(NotesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	}
	@Autowired
	PatientRepository patientRepository;

	// Run this if app.db.init.enabled = true
	@Bean
	public CommandLineRunner runner() {
		return args -> {

			Patient p1 = new Patient(1L, "Patient: TestNone Practitioner's\n" +
					"notes/recommendations: Patient states that\n" +
					"they are 'feeling terrific' Weight at or below\n" +
					"recommended level");
			Patient p2 = new Patient(2L, "Patient: TestBorderline Practitioner's\n" +
					"notes/recommendations: Patient states that\n" +
					"they are feeling a great deal of stress at work\n" +
					"Patient also complains that their hearing\n" +
					"seems Abnormal as of late\n");

			patientRepository.insert(p1);
			patientRepository.insert(p2);

		};
	}
}
