package com.example.crud.repository;

import com.example.crud.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    //find with name do it with any variable of database
    Patient findByName(String name);

    //group with multiple condition check for variable of database
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate,String email);

    //using query into this (:) using for params value check
    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

}
