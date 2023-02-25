package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.MedicalPosition;

@Repository
public interface MedicalPositionRepository extends JpaRepository<MedicalPosition, Long> {
}
