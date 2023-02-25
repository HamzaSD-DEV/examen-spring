package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.suptech.examenspring.domain.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
}
