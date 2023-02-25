package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
