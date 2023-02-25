package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.PrimeMedical;

@Repository
public interface PrimeMedicalRepository extends JpaRepository<PrimeMedical, Long> {
}
