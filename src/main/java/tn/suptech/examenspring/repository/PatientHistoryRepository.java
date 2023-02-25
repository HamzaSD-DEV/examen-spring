package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.PatientHistory;

@Repository
public interface PatientHistoryRepository extends JpaRepository<PatientHistory, Long> {
}
