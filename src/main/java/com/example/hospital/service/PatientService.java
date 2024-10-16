//Only logical part
package com.example.hospital.service;

import com.example.hospital.entities.Doctor;
import com.example.hospital.entities.Patient;
import com.example.hospital.repositories.DoctorRepository;
import com.example.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Patient> getAllPatient(){
        return  patientRepository.getAllPatient();
    }

    public Patient getPattientById(Integer id){
        return patientRepository.getPattientById(id);
    }

    public Patient addPatient(Patient patient){
        Doctor doctor = doctorRepository.getDoctorById(patient.getDoctorId());
        if ( doctor == null ) return null;
        Patient patientEntity = patientRepository.addPatient(patient);

        if(doctor.getPatients() == null){
            doctor.setPatients(new ArrayList<>());
            doctor.getPatients().add(patientEntity);
        }else{
            doctor.getPatients().add(patientEntity);
        }

        doctorRepository.updateDoctor(doctor);
        return patientEntity;
    }

    public Patient updatedPatient(Patient patient){
        return patientRepository.updatedPatient(patient);
    }

    public Patient deletePatient(Integer id){
        return patientRepository.deletePatient (id);
    }

}
