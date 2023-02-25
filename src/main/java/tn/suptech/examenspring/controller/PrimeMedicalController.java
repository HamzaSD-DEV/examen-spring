package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.PrimeMedical;
import tn.suptech.examenspring.service.PrimeMedicalService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prime-medical")
public class PrimeMedicalController {
    @Autowired
    private PrimeMedicalService primeMedicalService;

    @GetMapping("/")
    public ResponseEntity<List<PrimeMedical>> getAllPrimeMedical() {
        List<PrimeMedical> primeMedicals = primeMedicalService.getAllPrimeMedical();
        return new ResponseEntity<>(primeMedicals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrimeMedical> getPrimeMedicalById(@PathVariable("id") Long primeMedicalId) throws Exception {
        PrimeMedical primeMedical = primeMedicalService.getPrimeMedicalById(primeMedicalId);
        return new ResponseEntity<>(primeMedical, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PrimeMedical> addPrimeMedical(@RequestBody PrimeMedical primeMedical) {
        PrimeMedical newPrimeMedical = primeMedicalService.addPrimeMedical(primeMedical);
        return new ResponseEntity<>(newPrimeMedical, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PrimeMedical> updatePrimeMedical(@PathVariable("id") Long primeMedicalId, @RequestBody PrimeMedical primeMedicalDetails) throws Exception {
        PrimeMedical updatedPrimeMedical = primeMedicalService.updatePrimeMedical(primeMedicalId, primeMedicalDetails);
        return new ResponseEntity<>(updatedPrimeMedical, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePrimeMedical(@PathVariable("id") Long primeMedicalId) throws Exception {
        primeMedicalService.deletePrimeMedical(primeMedicalId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}