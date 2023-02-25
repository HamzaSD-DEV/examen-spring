package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.HistoriqueAdministratif;

@Repository
public interface HistoriqueAdministratifRepository extends JpaRepository<HistoriqueAdministratif, Long> {
}
