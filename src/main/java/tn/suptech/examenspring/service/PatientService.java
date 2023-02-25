package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.Patient;
import tn.suptech.examenspring.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long patientId) throws Exception {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isPresent()) {
            return patient.get();
        } else {
            throw new Exception("Patient not found with id " + patientId);
        }
    }

    public Patient updatePatient(Long patientId, Patient patientDetails) throws Exception {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isPresent()) {
            Patient existingPatient = patient.get();
            existingPatient.setCinNumber(patientDetails.getCinNumber());
            existingPatient.setSocialId(patientDetails.getSocialId());
            existingPatient.setFirstName(patientDetails.getFirstName());
            existingPatient.setLastName(patientDetails.getLastName());
            existingPatient.setBirthDate(patientDetails.getBirthDate());
            existingPatient.setSexe(patientDetails.getSexe());
            existingPatient.setAddress(patientDetails.getAddress());
            existingPatient.setPhoneNumber(patientDetails.getPhoneNumber());
            existingPatient.setEmail(patientDetails.getEmail());
            return patientRepository.save(existingPatient);
        } else {
            throw new Exception("Patient not found with id " + patientId);
        }
    }


    public boolean deletePatient(Long patientId) {
        try {
            patientRepository.deleteById(patientId);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Cannot delete patient with id " + patientId + " because it is associated with other entities.");
        }
    }
}
