package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.DoctorConsultation;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DoctorConsultationRepository extends JpaRepository<DoctorConsultation, Long> {

    List<DoctorConsultation> findByConsultationDate(LocalDate consultationDate);

    List<DoctorConsultation> findByPatientId(Long patientId);

    List<DoctorConsultation> findByMedicalStaffId(Long medicalStaffId);
}
