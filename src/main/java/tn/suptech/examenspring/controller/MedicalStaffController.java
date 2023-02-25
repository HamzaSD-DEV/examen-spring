package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.MedicalStaff;
import tn.suptech.examenspring.service.MedicalStaffService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medical-staff")
public class MedicalStaffController {
    @Autowired
    private MedicalStaffService medicalStaffService;

    @PostMapping
    public ResponseEntity<MedicalStaff> addMedicalStaff(@RequestBody MedicalStaff medicalStaff) {
        MedicalStaff savedMedicalStaff = medicalStaffService.addMedicalStaff(medicalStaff);
        return new ResponseEntity<>(savedMedicalStaff, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicalStaff>> getAllMedicalStaff() {
        List<MedicalStaff> medicalStaffList = medicalStaffService.getAllMedicalStaff();
        return new ResponseEntity<>(medicalStaffList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalStaff> getMedicalStaffById(@PathVariable("id") Long medicalStaffId) throws Exception {
        MedicalStaff medicalStaff = medicalStaffService.getMedicalStaffById(medicalStaffId);
        return new ResponseEntity<>(medicalStaff, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalStaff> updateMedicalStaff(@PathVariable("id") Long medicalStaffId, @RequestBody MedicalStaff medicalStaffDetails) throws Exception {
        MedicalStaff updatedMedicalStaff = medicalStaffService.updateMedicalStaff(medicalStaffId, medicalStaffDetails);
        return new ResponseEntity<>(updatedMedicalStaff, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMedicalStaff(@PathVariable("id") Long medicalStaffId) throws Exception {
        boolean result = medicalStaffService.deleteMedicalStaff(medicalStaffId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}