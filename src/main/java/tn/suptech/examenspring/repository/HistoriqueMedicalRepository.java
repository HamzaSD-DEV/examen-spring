package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.HistoriqueMedical;

@Repository
public interface HistoriqueMedicalRepository extends JpaRepository<HistoriqueMedical, Long> {
}
