package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.PatientHistory;
import tn.suptech.examenspring.repository.PatientHistoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientHistoryService {

    @Autowired
    private PatientHistoryRepository patientHistoryRepository;

    public PatientHistory addPatientHistory(PatientHistory patientHistory) {
        return patientHistoryRepository.save(patientHistory);
    }

    public List<PatientHistory> getAllPatientHistory() {
        return patientHistoryRepository.findAll();
    }

    public PatientHistory getPatientHistoryById(Long patientHistoryId) throws Exception {
        Optional<PatientHistory> patientHistory = patientHistoryRepository.findById(patientHistoryId);
        if (patientHistory.isPresent()) {
            return patientHistory.get();
        } else {
            throw new Exception("PatientHistory not found with id " + patientHistoryId);
        }
    }

    public PatientHistory updatePatientHistory(Long patientHistoryId, PatientHistory patientHistoryDetails) throws Exception {
        Optional<PatientHistory> patientHistory = patientHistoryRepository.findById(patientHistoryId);
        if (patientHistory.isPresent()) {
            PatientHistory existingPatientHistory = patientHistory.get();
            existingPatientHistory.setDate(patientHistoryDetails.getDate());
            existingPatientHistory.setPatient(patientHistoryDetails.getPatient());
            existingPatientHistory.setMedicalTests(patientHistoryDetails.getMedicalTests());
            existingPatientHistory.setDoctorConsultations(patientHistoryDetails.getDoctorConsultations());
            existingPatientHistory.setOperationChirurgicals(patientHistoryDetails.getOperationChirurgicals());
            existingPatientHistory.setRoomStays(patientHistoryDetails.getRoomStays());
            existingPatientHistory.setMedications(patientHistoryDetails.getMedications());
            return patientHistoryRepository.save(existingPatientHistory);
        } else {
            throw new Exception("PatientHistory not found with id " + patientHistoryId);
        }
    }

    public boolean deletePatientHistory(Long patientHistoryId) throws Exception {
        Optional<PatientHistory> patientHistory = patientHistoryRepository.findById(patientHistoryId);
        if (patientHistory.isPresent()) {
            patientHistoryRepository.deleteById(patientHistoryId);
            return true;
        } else {
            throw new Exception("PatientHistory not found with id " + patientHistoryId);
        }
    }
}
