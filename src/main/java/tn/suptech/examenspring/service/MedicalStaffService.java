package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.MedicalStaff;
import tn.suptech.examenspring.repository.MedicalStaffRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalStaffService {

    @Autowired
    private MedicalStaffRepository medicalStaffRepository;

    public MedicalStaff addMedicalStaff(MedicalStaff medicalStaff) {
        return medicalStaffRepository.save(medicalStaff);
    }

    public List<MedicalStaff> getAllMedicalStaff() {
        return medicalStaffRepository.findAll();
    }

    public MedicalStaff getMedicalStaffById(Long medicalStaffId) throws Exception {
        Optional<MedicalStaff> medicalStaff = medicalStaffRepository.findById(medicalStaffId);
        if (medicalStaff.isPresent()) {
            return medicalStaff.get();
        } else {
            throw new Exception("Medical staff not found with id " + medicalStaffId);
        }
    }

    public MedicalStaff updateMedicalStaff(Long medicalStaffId, MedicalStaff medicalStaffDetails) throws Exception {
        Optional<MedicalStaff> medicalStaff = medicalStaffRepository.findById(medicalStaffId);
        if (medicalStaff.isPresent()) {
            MedicalStaff existingMedicalStaff = medicalStaff.get();
            existingMedicalStaff.setFirstName(medicalStaffDetails.getFirstName());
            existingMedicalStaff.setLastName(medicalStaffDetails.getLastName());
            existingMedicalStaff.setSexe(medicalStaffDetails.getSexe());
            existingMedicalStaff.setCinNumber(medicalStaffDetails.getCinNumber());
            existingMedicalStaff.setBank(medicalStaffDetails.getBank());
            existingMedicalStaff.setRib(medicalStaffDetails.getRib());
            existingMedicalStaff.setPhoneNumber(medicalStaffDetails.getPhoneNumber());
            existingMedicalStaff.setEmail(medicalStaffDetails.getEmail());
            existingMedicalStaff.setPosition(medicalStaffDetails.getPosition());
            return medicalStaffRepository.save(existingMedicalStaff);
        } else {
            throw new Exception("Medical staff not found with id " + medicalStaffId);
        }
    }

    public boolean deleteMedicalStaff(Long medicalStaffId) throws Exception {
        Optional<MedicalStaff> medicalStaff = medicalStaffRepository.findById(medicalStaffId);
        if (medicalStaff.isPresent()) {
            medicalStaffRepository.deleteById(medicalStaffId);
            return true;
        } else {
            throw new Exception("Medical staff not found with id " + medicalStaffId);
        }
    }
}
