package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.MedicalStaff;

@Repository
public interface MedicalStaffRepository extends JpaRepository<MedicalStaff, Long> {
}
