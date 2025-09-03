package com.example.crud;

import com.example.crud.model.Patient;
import com.example.crud.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testTransactionMethods(){

        Patient patient = patientRepository.findByName("Aarav Sharma");

//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1988, 3, 15), "diya" + ".patel@example.com");
        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1994, 3, 14));
        for (Patient p: patientList){
            System.out.println(p);
        }
//        System.out.println(patient);

    }

}
