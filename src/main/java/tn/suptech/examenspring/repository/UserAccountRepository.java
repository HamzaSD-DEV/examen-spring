package tn.suptech.examenspring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.User;

@Repository
public interface UserAccountRepository extends JpaRepository<User, Long> {
    @Query
    User findByUsername(String username);
}
