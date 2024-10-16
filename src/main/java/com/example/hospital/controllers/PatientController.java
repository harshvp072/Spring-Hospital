package com.example.hospital.controllers;

import com.example.hospital.entities.Patient;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/patients")

public class PatientController {

    @Autowired
    private PatientService patientService;

//  Read
    @GetMapping("/all")
    public List<Patient> getAllPatient(){
        return patientService.getAllPatient();
    }

    @GetMapping("/{id}")
    public Patient getPattientById(@PathVariable int id){
        return patientService.getPattientById(id);
    }

//  Create
    @PostMapping("")
    public Patient addPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }

//  Update
    @PatchMapping("")
    public Patient updatedPatient(@RequestBody Patient patient){
        return patientService.updatedPatient(patient);
    }

//    Delete
    @DeleteMapping("/{id}")
    public Patient deletePatient(@PathVariable int id){
        return patientService.deletePatient(id);
    }

}
