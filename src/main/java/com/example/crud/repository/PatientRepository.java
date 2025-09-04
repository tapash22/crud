package com.example.crud.repository;

import com.example.crud.dto.BloodGroupCountResponseEntity;
import com.example.crud.model.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    //make group and use count
//    @Query("select p.bloodGroup, Count (p) from Patient p group by p.bloodGroup")
//    List<Object[]> countEachBloodGroupType();

    //make group and use count
    //using same thing with DTO
    @Query("select new com.example.crud.dto.BloodGroupCountResponseEntity( p.bloodGroup," +
            " Count (p)) from Patient p group by p.bloodGroup")
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    // using native query
//    @Query(value = "select * from patient", nativeQuery = true)
//    List<Patient> findAllPatients();

    //update value with Modifying using also Transactional
    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET name= :name where id= :id")
    int updateNameWithId (@Param("name") String name, @Param("id") Long id);

    // using pagination
    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);

}
