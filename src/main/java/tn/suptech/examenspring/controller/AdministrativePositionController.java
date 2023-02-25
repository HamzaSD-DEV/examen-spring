package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.AdministrativePosition;
import tn.suptech.examenspring.service.AdministrativePositionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/administrative-positions")
public class AdministrativePositionController {

    @Autowired
    private AdministrativePositionService administrativePositionService;

    @PostMapping("/add")
    public ResponseEntity<AdministrativePosition> addAdministrativePosition(@RequestBody AdministrativePosition administrativePosition) {
        AdministrativePosition createdAdministrativePosition = administrativePositionService.addAdministrativePosition(administrativePosition);
        return new ResponseEntity<>(createdAdministrativePosition, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<AdministrativePosition>> getAllAdministrativePositions() {
        List<AdministrativePosition> administrativePositions = administrativePositionService.getAllAdministrativePositions();
        return new ResponseEntity<>(administrativePositions, HttpStatus.OK);
    }

    @GetMapping("/{administrativePositionId}")
    public ResponseEntity<AdministrativePosition> getAdministrativePositionById(@PathVariable Long administrativePositionId) throws Exception {
        AdministrativePosition administrativePosition = administrativePositionService.getAdministrativePositionById(administrativePositionId);
        return new ResponseEntity<>(administrativePosition, HttpStatus.OK);
    }

    @GetMapping("/position-name/{positionName}")
    public ResponseEntity<AdministrativePosition> getAdministrativePositionByPositionName(@PathVariable String positionName) throws Exception {
        AdministrativePosition administrativePosition = administrativePositionService.getAdministrativePositionByPositionName(positionName);
        return new ResponseEntity<>(administrativePosition, HttpStatus.OK);
    }

    @PutMapping("/update/{positionId}")
    public ResponseEntity<AdministrativePosition> updateAdministrativePosition(@PathVariable Long positionId, @RequestBody AdministrativePosition positionDetails) throws Exception {
        AdministrativePosition updatedAdministrativePosition = administrativePositionService.updateAdministrativePosition(positionId, positionDetails);
        return new ResponseEntity<>(updatedAdministrativePosition, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{administrativePositionId}")
    public ResponseEntity<String> deleteAdministrativePosition(@PathVariable Long administrativePositionId) {
        boolean deleted = administrativePositionService.deleteAdministrativePosition(administrativePositionId);
        if (deleted) {
            return new ResponseEntity<>("Administrative position with id " + administrativePositionId + " deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unable to delete administrative position with id " + administrativePositionId + ".", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
