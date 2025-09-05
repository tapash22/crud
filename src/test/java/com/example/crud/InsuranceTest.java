package com.example.crud;

import com.example.crud.model.Appointment;
import com.example.crud.model.Insurance;
import com.example.crud.model.Patient;
import com.example.crud.service.AppointmentService;
import com.example.crud.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance(){
        Insurance insurance =  Insurance.builder()
                .policyNumber("fhfhf_hh")
                .provider("hdhd")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);

       Patient removeP = insuranceService.removeInsurance(patient.getId());
        System.out.println(removeP);

    }

    @Test
    public void testAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,2,14,30))
                .reason("sick")
                .build();

        Appointment newAppointment = appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println(newAppointment);

        Appointment anotherAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(),2L);
        System.out.println(anotherAppointment);
    }
}
