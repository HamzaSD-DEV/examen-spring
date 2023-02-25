package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.DoctorConsultation;
import tn.suptech.examenspring.repository.DoctorConsultationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorConsultationService {

    @Autowired
    private DoctorConsultationRepository doctorConsultationRepository;

    public DoctorConsultation addDoctorConsultation(DoctorConsultation doctorConsultation) {
        return doctorConsultationRepository.save(doctorConsultation);
    }

    public List<DoctorConsultation> getAllDoctorConsultations() {
        return doctorConsultationRepository.findAll();
    }

    public DoctorConsultation getDoctorConsultationById(Long doctorConsultationId) throws Exception {
        Optional<DoctorConsultation> doctorConsultation = doctorConsultationRepository.findById(doctorConsultationId);
        if (doctorConsultation.isPresent()) {
            return doctorConsultation.get();
        } else {
            throw new Exception("Doctor consultation not found with id " + doctorConsultationId);
        }
    }

    public List<DoctorConsultation> getDoctorConsultationByConsultationDate(LocalDate consultationDate) {
        return doctorConsultationRepository.findByConsultationDate(consultationDate);
    }

    public DoctorConsultation updateDoctorConsultation(Long doctorConsultationId, DoctorConsultation doctorConsultationDetails) throws Exception {
        Optional<DoctorConsultation> doctorConsultation = doctorConsultationRepository.findById(doctorConsultationId);
        if (doctorConsultation.isPresent()) {
            DoctorConsultation existingDoctorConsultation = doctorConsultation.get();
            existingDoctorConsultation.setMedicalStaff(doctorConsultationDetails.getMedicalStaff());
            existingDoctorConsultation.setPatient(doctorConsultationDetails.getPatient());
            existingDoctorConsultation.setConsultationDate(doctorConsultationDetails.getConsultationDate());
            existingDoctorConsultation.setObservations(doctorConsultationDetails.getObservations());
            existingDoctorConsultation.setPatientHistory(doctorConsultationDetails.getPatientHistory());
            return doctorConsultationRepository.save(existingDoctorConsultation);
        } else {
            throw new Exception("Doctor consultation not found with id " + doctorConsultationId);
        }
    }

    public boolean deleteDoctorConsultation(Long doctorConsultationId) {
        try {
            doctorConsultationRepository.deleteById(doctorConsultationId);
            return true;
        } catch (Exception ex) {
            throw new RuntimeException("Cannot delete doctor consultation with id " + doctorConsultationId + ". " + ex.getMessage());
        }

    }

    public List<DoctorConsultation> getDoctorConsultationsByPatientId(Long patientId) {
        return doctorConsultationRepository.findByPatientId(patientId);
    }

    public List<DoctorConsultation> getDoctorConsultationsByMedicalStaffId(Long medicalStaffId) {
        return doctorConsultationRepository.findByMedicalStaffId(medicalStaffId);
    }
}