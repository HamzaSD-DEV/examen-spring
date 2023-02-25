package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.MedicalTest;
import tn.suptech.examenspring.repository.MedicalTestRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalTestService {

    @Autowired
    private MedicalTestRepository medicalTestRepository;

    public MedicalTest addMedicalTest(MedicalTest medicalTest) {
        return medicalTestRepository.save(medicalTest);
    }

    public List<MedicalTest> getAllMedicalTests() {
        return medicalTestRepository.findAll();
    }

    public MedicalTest getMedicalTestById(Long medicalTestId) throws Exception {
        Optional<MedicalTest> medicalTest = medicalTestRepository.findById(medicalTestId);
        if (medicalTest.isPresent()) {
            return medicalTest.get();
        } else {
            throw new Exception("Medical test not found with id " + medicalTestId);
        }
    }

    public MedicalTest updateMedicalTest(Long medicalTestId, MedicalTest medicalTestDetails) throws Exception {
        Optional<MedicalTest> medicalTest = medicalTestRepository.findById(medicalTestId);
        if (medicalTest.isPresent()) {
            MedicalTest existingMedicalTest = medicalTest.get();
            existingMedicalTest.setTestResult(medicalTestDetails.getTestResult());
            existingMedicalTest.setPatient(medicalTestDetails.getPatient());
            existingMedicalTest.setPatientHistory(medicalTestDetails.getPatientHistory());
            existingMedicalTest.setMedicalStaff(medicalTestDetails.getMedicalStaff());
            existingMedicalTest.setMedicalTestType(medicalTestDetails.getMedicalTestType());
            existingMedicalTest.setTestDate(medicalTestDetails.getTestDate());
            return medicalTestRepository.save(existingMedicalTest);
        } else {
            throw new Exception("Medical test not found with id " + medicalTestId);
        }
    }

    public boolean deleteMedicalTest(Long medicalTestId) {
        try {
            medicalTestRepository.deleteById(medicalTestId);
            return true;
        } catch (Exception ex) {
            throw new RuntimeException("Cannot delete medical test with id " + medicalTestId + " because it is associated with other entities.");
        }

    }
}
