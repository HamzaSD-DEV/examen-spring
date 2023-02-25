package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.MedicalTestType;

@Repository
public interface MedicalTestTypeRepository extends JpaRepository<MedicalTestType, Long> {
}
