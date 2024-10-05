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

			Patient p1 = new Patient("the patient only exercises at most once a week");
			Patient p2 = new Patient("demo notes");

			patientRepository.insert(p1);
			patientRepository.insert(p2);

		};
	}
}
