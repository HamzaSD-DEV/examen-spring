package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.AdministrativePosition;

import java.util.Optional;

@Repository
public interface AdministrativePositionRepository extends JpaRepository<AdministrativePosition, Long> {

    Optional<AdministrativePosition> findByPositionName(String positionName);
}