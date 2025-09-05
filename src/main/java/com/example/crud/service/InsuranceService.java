package com.example.crud.service;


import com.example.crud.model.Insurance;
import com.example.crud.model.Patient;
import com.example.crud.repository.InsuranceRepository;
import com.example.crud.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //use final for required
public class InsuranceService {
    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); // keep bidirectional sync

        insuranceRepository.save(insurance); // save insurance
        return patientRepository.save(patient); // save patient
    }

    //remove Insurance
     @Transactional
    public  Patient removeInsurance(Long patientId){

        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(null);
        return patient;
     }
}
