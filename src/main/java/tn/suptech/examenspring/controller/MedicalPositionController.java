package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.MedicalPosition;
import tn.suptech.examenspring.service.MedicalPositionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medical-positions")
public class MedicalPositionController {
    @Autowired
    private MedicalPositionService medicalPositionService;

    @GetMapping("/")
    public List<MedicalPosition> getAllMedicalPositions() {
        return medicalPositionService.getAllMedicalPositions();
    }

    @GetMapping("/{medicalPositionId}")
    public ResponseEntity<MedicalPosition> getMedicalPositionById(@PathVariable Long medicalPositionId) throws Exception {
        MedicalPosition medicalPosition = medicalPositionService.getMedicalPositionById(medicalPositionId);
        return new ResponseEntity<>(medicalPosition, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MedicalPosition> addMedicalPosition(@RequestBody MedicalPosition medicalPosition) {
        MedicalPosition newMedicalPosition = medicalPositionService.addMedicalPosition(medicalPosition);
        return new ResponseEntity<>(newMedicalPosition, HttpStatus.CREATED);
    }

    @PutMapping("/update/{medicalPositionId}")
    public ResponseEntity<MedicalPosition> updateMedicalPosition(@PathVariable Long medicalPositionId, @RequestBody MedicalPosition medicalPositionDetails) throws Exception {
        MedicalPosition updatedMedicalPosition = medicalPositionService.updateMedicalPosition(medicalPositionId, medicalPositionDetails);
        return new ResponseEntity<>(updatedMedicalPosition, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{medicalPositionId}")
    public ResponseEntity<?> deleteMedicalPosition(@PathVariable Long medicalPositionId) throws Exception {
        boolean deleted = medicalPositionService.deleteMedicalPosition(medicalPositionId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

