package tn.suptech.examenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenspring.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {


}
