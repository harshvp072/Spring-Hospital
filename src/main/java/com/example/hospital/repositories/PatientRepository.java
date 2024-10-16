//This layer will manage data

package com.example.hospital.repositories;
import com.example.hospital.entities.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PatientRepository {
    private HashMap<Integer, Patient> patients = new HashMap<>();
    private int idCounter = 1;

    public List<Patient> getAllPatient(){
        return new ArrayList<>(patients.values());
    }

    public Patient getPattientById(Integer id){
        return patients.get(id);
    }

    public Patient addPatient(Patient patient){
        patient.setId(idCounter++);
        patients.put(patient.getId(),patient);
        return patient;
    }

    public Patient updatedPatient(Patient patient){
        Patient oldPatient = patients.get(patient.getId());
        if(oldPatient != null){
            oldPatient.setName(patient.getName());
            oldPatient.setDisease(patient.getDisease());
            oldPatient.setAge(patient.getAge());
        }
        return patients.put(patient.getId(),patient);
    }

    public Patient deletePatient(Integer id){
        return patients.remove(id);
    }
}
