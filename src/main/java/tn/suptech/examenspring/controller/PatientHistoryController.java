package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.PatientHistory;
import tn.suptech.examenspring.service.PatientHistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient-history")
public class PatientHistoryController {

    @Autowired
    private PatientHistoryService patientHistoryService;

    @PostMapping("/add")
    public ResponseEntity<PatientHistory> addPatientHistory(@RequestBody PatientHistory patientHistory) {
        PatientHistory newPatientHistory = patientHistoryService.addPatientHistory(patientHistory);
        return new ResponseEntity<>(newPatientHistory, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<PatientHistory>> getAllPatientHistory() {
        List<PatientHistory> patientHistoryList = patientHistoryService.getAllPatientHistory();
        return new ResponseEntity<>(patientHistoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientHistory> getPatientHistoryById(@PathVariable("id") Long patientHistoryId) throws Exception {
        PatientHistory patientHistory = patientHistoryService.getPatientHistoryById(patientHistoryId);
        return new ResponseEntity<>(patientHistory, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PatientHistory> updatePatientHistory(@PathVariable("id") Long patientHistoryId, @RequestBody PatientHistory patientHistoryDetails) throws Exception {
        PatientHistory updatedPatientHistory = patientHistoryService.updatePatientHistory(patientHistoryId, patientHistoryDetails);
        return new ResponseEntity<>(updatedPatientHistory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePatientHistory(@PathVariable("id") Long patientHistoryId) throws Exception {
        patientHistoryService.deletePatientHistory(patientHistoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
