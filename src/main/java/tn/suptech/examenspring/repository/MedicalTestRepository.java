package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.MedicalTest;

@Repository
public interface MedicalTestRepository extends JpaRepository<MedicalTest, Long> {
}
