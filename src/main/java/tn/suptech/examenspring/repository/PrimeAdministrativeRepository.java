package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.PrimeAdministrative;

@Repository
public interface PrimeAdministrativeRepository extends JpaRepository<PrimeAdministrative, Long> {
}
