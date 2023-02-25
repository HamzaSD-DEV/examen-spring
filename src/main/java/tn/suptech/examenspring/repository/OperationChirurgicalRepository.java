package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.OperationChirurgical;

@Repository
public interface OperationChirurgicalRepository extends JpaRepository<OperationChirurgical, Long> {
}
