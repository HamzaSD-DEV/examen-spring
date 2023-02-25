package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.AdministrativeStaff;

import java.util.Optional;

@Repository
public interface AdministrativeStaffRepository extends JpaRepository<AdministrativeStaff, Long> {

    Optional<AdministrativeStaff> findByCinNumber(Long cinNumber);
}
