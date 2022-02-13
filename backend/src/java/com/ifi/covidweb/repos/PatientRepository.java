package com.ifi.covidweb.repos;

import com.ifi.covidweb.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p")
    List<Patient> findAll();

    @Query("SELECT p FROM Patient p where p.id=:id")
    Patient findById(@Param("id") int id);

}
