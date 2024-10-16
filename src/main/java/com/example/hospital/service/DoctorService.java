package com.example.hospital.service;

import com.example.hospital.entities.Doctor;
import com.example.hospital.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public ArrayList<Doctor> getAllDoctor(){
        return doctorRepository.getAllDoctor();
    }

    public Doctor getDoctorById(int id){
        return doctorRepository.getDoctorById(id);
    }

    public Doctor addDoctor(Doctor doctor){
        return doctorRepository.addDoctor(doctor);
    }

    public Doctor updateDoctor(Doctor doctor){
        return doctorRepository.updateDoctor(doctor);
    }

    public Doctor deleteDoctor(int id){
        return doctorRepository.deleteDoctor(id);
    }

}
