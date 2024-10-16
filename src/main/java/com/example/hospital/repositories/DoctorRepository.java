package com.example.hospital.repositories;

import com.example.hospital.entities.Doctor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class DoctorRepository {
    private HashMap<Integer, Doctor> doctorMap = new HashMap<>();
    private int idCounter = 1;

    public ArrayList<Doctor> getAllDoctor(){ return new ArrayList<>(doctorMap.values()); }

    public Doctor getDoctorById(int id){
        return doctorMap.get(id);
    }

    public Doctor addDoctor(Doctor doctor){
        doctor.setId(idCounter++);
        doctorMap.put(doctor.getId(),doctor);
        return doctor;
    }

    public Doctor updateDoctor(Doctor doctor){
        return doctorMap.put(doctor.getId(),doctor);
    }

    public Doctor deleteDoctor(int id){
        return doctorMap.remove(id);
    }
}