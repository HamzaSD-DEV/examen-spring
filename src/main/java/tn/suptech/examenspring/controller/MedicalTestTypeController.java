package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.MedicalTestType;
import tn.suptech.examenspring.service.MedicalTestTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medical-test-types")
public class MedicalTestTypeController {

    @Autowired
    private MedicalTestTypeService medicalTestTypeService;

    @PostMapping("/add")
    public ResponseEntity<MedicalTestType> addMedicalTestType(@RequestBody MedicalTestType medicalTestType) {
        MedicalTestType savedMedicalTestType = medicalTestTypeService.addMedicalTestType(medicalTestType);
        return new ResponseEntity<>(savedMedicalTestType, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<MedicalTestType>> getAllMedicalTestTypes() {
        List<MedicalTestType> medicalTestTypes = medicalTestTypeService.getAllMedicalTestTypes();
        return new ResponseEntity<>(medicalTestTypes, HttpStatus.OK);
    }

    @GetMapping("/{medicalTestTypeId}")
    public ResponseEntity<MedicalTestType> getMedicalTestTypeById(@PathVariable Long medicalTestTypeId) throws Exception {
        MedicalTestType medicalTestType = medicalTestTypeService.getMedicalTestTypeById(medicalTestTypeId);
        return new ResponseEntity<>(medicalTestType, HttpStatus.OK);
    }

    @PutMapping("/update/{medicalTestTypeId}")
    public ResponseEntity<MedicalTestType> updateMedicalTestType(@PathVariable Long medicalTestTypeId, @RequestBody MedicalTestType medicalTestTypeDetails) throws Exception {
        MedicalTestType updatedMedicalTestType = medicalTestTypeService.updateMedicalTestType(medicalTestTypeId, medicalTestTypeDetails);
        return new ResponseEntity<>(updatedMedicalTestType, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{medicalTestTypeId}")
    public ResponseEntity<Void> deleteMedicalTestType(@PathVariable Long medicalTestTypeId) {
        boolean deleted = medicalTestTypeService.deleteMedicalTestType(medicalTestTypeId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
