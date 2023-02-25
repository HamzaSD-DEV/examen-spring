package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.RoomStay;
import tn.suptech.examenspring.repository.RoomStayRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomStayService {

    @Autowired
    private RoomStayRepository roomStayRepository;

    public RoomStay addRoomStay(RoomStay roomStay) {
        return roomStayRepository.save(roomStay);
    }

    public List<RoomStay> getAllRoomStays() {
        return roomStayRepository.findAll();
    }

    public RoomStay getRoomStayById(Long id) throws Exception {
        Optional<RoomStay> roomStay = roomStayRepository.findById(id);
        if (roomStay.isPresent()) {
            return roomStay.get();
        } else {
            throw new Exception("RoomStay not found with id " + id);
        }
    }

    public List<RoomStay> getRoomStaysByPatient(Long patientId) {
        return roomStayRepository.findByPatient(patientId);
    }

    public List<RoomStay> getRoomStaysByRoom(Long roomId) {
        return roomStayRepository.findByRoom(roomId);
    }

    public RoomStay updateRoomStay(Long id, RoomStay newRoomStay) throws Exception {
        Optional<RoomStay> optionalRoomStay = roomStayRepository.findById(id);
        if (optionalRoomStay.isPresent()) {
            RoomStay roomStay = optionalRoomStay.get();
            roomStay.setPatient(newRoomStay.getPatient());
            roomStay.setRoom(newRoomStay.getRoom());
            roomStay.setStartDate(newRoomStay.getStartDate());
            roomStay.setEndDate(newRoomStay.getEndDate());
            roomStay.setPatientHistory(newRoomStay.getPatientHistory());
            return roomStayRepository.save(roomStay);
        } else {
            throw new Exception("RoomStay not found with id " + id);
        }
    }


    public void deleteRoomStay(Long id) throws Exception {
        Optional<RoomStay> roomStay = roomStayRepository.findById(id);
        if (roomStay.isPresent()) {
            roomStayRepository.deleteById(id);
        } else {
            throw new Exception("RoomStay not found with id " + id);
        }
    }
}
