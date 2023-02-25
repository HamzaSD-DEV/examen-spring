package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.Pharmacie;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie, Long> {
}
