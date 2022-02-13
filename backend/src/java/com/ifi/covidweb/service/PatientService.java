package com.ifi.covidweb.service;

import com.ifi.covidweb.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAll();
    void add(Patient patient);
    Patient findById(int id);
    Patient save(Patient patient);
}
