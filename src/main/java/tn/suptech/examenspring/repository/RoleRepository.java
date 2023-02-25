package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
