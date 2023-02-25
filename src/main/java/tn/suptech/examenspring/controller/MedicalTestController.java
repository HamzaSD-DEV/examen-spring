package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.MedicalTest;
import tn.suptech.examenspring.service.MedicalTestService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medical-test")
public class MedicalTestController {

    @Autowired
    private MedicalTestService medicalTestService;

    @GetMapping("/")
    public List<MedicalTest> getAllMedicalTests() {
        return medicalTestService.getAllMedicalTests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMedicalTestById(@PathVariable("id") Long medicalTestId) {
        try {
            MedicalTest medicalTest = medicalTestService.getMedicalTestById(medicalTestId);
            return new ResponseEntity<>(medicalTest, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMedicalTest(@RequestBody MedicalTest medicalTest) {
        MedicalTest savedMedicalTest = medicalTestService.addMedicalTest(medicalTest);
        return new ResponseEntity<>(savedMedicalTest, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMedicalTest(@PathVariable("id") Long medicalTestId, @RequestBody MedicalTest medicalTest) {
        try {
            MedicalTest updatedMedicalTest = medicalTestService.updateMedicalTest(medicalTestId, medicalTest);
            return new ResponseEntity<>(updatedMedicalTest, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMedicalTest(@PathVariable("id") Long medicalTestId) {
        try {
            boolean result = medicalTestService.deleteMedicalTest(medicalTestId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
