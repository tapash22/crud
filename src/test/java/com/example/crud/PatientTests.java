package com.example.crud;

import com.example.crud.dto.BloodGroupCountResponseEntity;
import com.example.crud.model.Patient;
import com.example.crud.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testTransactionMethods(){

//        Patient patient = patientRepository.findByName("Aarav Sharma");

//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1988, 3, 15), "diya" + ".patel@example.com");
//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1994, 3, 14));
//        List<Object[]> bloodGroupCount = patientRepository.countEachBloodGroupType();
//
//        List<Patient> patientList = patientRepository.findAllPatients();
//        for(Object[] obj : bloodGroupCount){
//            System.out.println(obj[0]+" :"+obj[1]);
//        }
//        for (Patient p: patientList){
//            System.out.println(p);
//        }

//        int rowsUpdated = patientRepository.updateNameWithId("Tapash",1L);
//       System.out.println(rowsUpdated);
//
//        List<BloodGroupCountResponseEntity> bloodGroupCount = patientRepository.countEachBloodGroupType();
//
//                for(BloodGroupCountResponseEntity bloodGroupCountResponseEntity : bloodGroupCount){
//            System.out.println(bloodGroupCountResponseEntity);
//        }

        //into this using page for data display as pagewise, page_request.of
        // use for page_number and page_size also added Sort.by for sort the page as property sort
        Page<Patient> patientList = patientRepository.findAllPatients(PageRequest.of(1,2, Sort.by("name")));

        for(Patient patient:patientList){
            System.out.println(patient);
        }

    }


}
