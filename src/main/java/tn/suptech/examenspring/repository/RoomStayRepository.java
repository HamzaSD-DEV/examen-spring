package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.RoomStay;

import java.util.List;

@Repository
public interface RoomStayRepository extends JpaRepository<RoomStay, Long> {
    @Query
    List<RoomStay> findByPatient(Long patient);

    @Query
    List<RoomStay> findByRoom(Long room);
}
