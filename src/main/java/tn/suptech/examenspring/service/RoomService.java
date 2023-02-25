package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.Room;
import tn.suptech.examenspring.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long roomId) throws Exception {
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isPresent()) {
            return room.get();
        } else {
            throw new Exception("Room not found with id " + roomId);
        }
    }

    public Room updateRoom(Long roomId, Room roomDetails) throws Exception {
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isPresent()) {
            Room existingRoom = room.get();
            existingRoom.setNom(roomDetails.getNom());
            existingRoom.setType(roomDetails.getType());
            existingRoom.setPrixJour(roomDetails.getPrixJour());
            existingRoom.setCapaciteRoum(roomDetails.getCapaciteRoum());
            existingRoom.setLoadRoum(roomDetails.getLoadRoum());
            existingRoom.setSaturationRoum(roomDetails.getSaturationRoum());
            existingRoom.setOperatingBloc(roomDetails.getOperatingBloc());
            return roomRepository.save(existingRoom);
        } else {
            throw new Exception("Room not found with id " + roomId);
        }
    }

    public boolean deleteRoom(Long roomId) {
        try {
            roomRepository.deleteById(roomId);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Cannot delete room with id " + roomId + " because it is associated with other entities.");
        }
    }
}
