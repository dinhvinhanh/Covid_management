package com.ifi.covidweb.controller;

import com.ifi.covidweb.common.Output;
import com.ifi.covidweb.common.Storage;
import com.ifi.covidweb.entity.Patient;
import com.ifi.covidweb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

@CrossOrigin(value = {"*"}, exposedHeaders = {"Content-Disposition"})
@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/patient/list")
    public List<Patient> getAll() {
        List<Patient> patientDB = patientService.findAll();
        return patientDB;
    }

    @PostMapping("/patient/add")
    public Output add(@RequestBody Patient patient) {
        Output out = new Output();
        ResourceBundle r = ResourceBundle.getBundle("Bundle/config_en");
        Map<String, String> map = new HashMap<>();
        try {
            Storage storage = new Storage();
            String image = patient.getIconPath().trim();
            Map<String, String> mapImg = storage.storeFile(image, "identify");
            mapImg.entrySet().stream().map((entry) -> {
                String key = entry.getKey();
                String value = entry.getValue();
                map.put(key, value);
                return key;
            }).forEachOrdered((key) -> {
                patient.setIconPath(key);
            });
            patientService.add(patient);
            out.setResult(3);
            out.setMessage(r.getString("3"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return out;
    }

    @PostMapping("/patient/update")
    public Output update(@RequestBody Patient patient) {
        Output out = new Output();
        ResourceBundle r = ResourceBundle.getBundle("Bundle/config_en");
        Patient patientUpdate = patientService.findById(patient.getId());
        patientService.save(patientUpdate);
        out.setMessage(r.getString("4"));
        return out;
    }
}
