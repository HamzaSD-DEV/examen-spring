package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.Medication;
import tn.suptech.examenspring.service.MedicationService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medications")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    @GetMapping("/")
    public List<Medication> getAllMedications() {
        return medicationService.getAllMedications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable("id") Long medicationId) {
        try {
            Medication medication = medicationService.getMedicationById(medicationId);
            return new ResponseEntity<>(medication, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Medication> addMedication(@RequestBody Medication medication) {
        Medication addedMedication = medicationService.addMedication(medication);
        return new ResponseEntity<>(addedMedication, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Medication> updateMedication(@PathVariable("id") Long medicationId, @RequestBody Medication medicationDetails) {
        try {
            Medication updatedMedication = medicationService.updateMedication(medicationId, medicationDetails);
            return new ResponseEntity<>(updatedMedication, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteMedication(@PathVariable("id") Long medicationId) {
        try {
            boolean deleted = medicationService.deleteMedication(medicationId);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
