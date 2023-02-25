package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.RoomStay;
import tn.suptech.examenspring.service.RoomStayService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/room-stays")
public class RoomStayController {

    @Autowired
    private RoomStayService roomStayService;

    @PostMapping("/add")
    public ResponseEntity<RoomStay> addRoomStay(@RequestBody RoomStay roomStay) {
        RoomStay createdRoomStay = roomStayService.addRoomStay(roomStay);
        return new ResponseEntity<>(createdRoomStay, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<RoomStay>> getAllRoomStays() {
        List<RoomStay> roomStays = roomStayService.getAllRoomStays();
        return new ResponseEntity<>(roomStays, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomStay> getRoomStayById(@PathVariable Long id) throws Exception {
        RoomStay roomStay = roomStayService.getRoomStayById(id);
        return new ResponseEntity<>(roomStay, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RoomStay> updateRoomStay(@PathVariable Long id, @RequestBody RoomStay roomStayDetails) throws Exception {
        RoomStay updatedRoomStay = roomStayService.updateRoomStay(id, roomStayDetails);
        return new ResponseEntity<>(updatedRoomStay, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRoomStay(@PathVariable Long id) {
        try {
            roomStayService.deleteRoomStay(id);
            return new ResponseEntity<>("RoomStay with id " + id + " has been deleted.", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
