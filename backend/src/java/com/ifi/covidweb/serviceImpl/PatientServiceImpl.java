package com.ifi.covidweb.serviceImpl;

import com.ifi.covidweb.entity.Patient;
import com.ifi.covidweb.repos.PatientRepository;
import com.ifi.covidweb.service.PatientService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private static Logger log;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public void add(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient findById(int id) {
        try {
            Patient patient = patientRepository.findById(id);
            if (patient != null) {
                return patient;
            }
        } catch (
                Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }
}
