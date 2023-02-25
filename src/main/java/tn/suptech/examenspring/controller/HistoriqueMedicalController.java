package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.HistoriqueMedical;
import tn.suptech.examenspring.service.HistoriqueMedicalService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/historique-medical")
public class HistoriqueMedicalController {
    @Autowired
    private HistoriqueMedicalService historiqueMedicalService;

    @PostMapping("/add")
    public ResponseEntity<HistoriqueMedical> addHistoriqueMedical(@RequestBody HistoriqueMedical historiqueMedical) {
        return new ResponseEntity<>(historiqueMedicalService.addHistoriqueMedical(historiqueMedical), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<HistoriqueMedical>> getAllHistoriqueMedicals() {
        return new ResponseEntity<>(historiqueMedicalService.getAllHistoriqueMedicals(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriqueMedical> getHistoriqueMedicalById(@PathVariable("id") Long historiqueMedicalId) throws Exception {
        return new ResponseEntity<>(historiqueMedicalService.getHistoriqueMedicalById(historiqueMedicalId), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HistoriqueMedical> updateHistoriqueMedical(@PathVariable("id") Long historiqueMedicalId, @RequestBody HistoriqueMedical historiqueMedicalDetails) throws Exception {
        return new ResponseEntity<>(historiqueMedicalService.updateHistoriqueMedical(historiqueMedicalId, historiqueMedicalDetails), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHistoriqueMedical(@PathVariable("id") Long historiqueMedicalId) {
        boolean isDeleted = historiqueMedicalService.deleteHistoriqueMedical(historiqueMedicalId);
        if (isDeleted) {
            return new ResponseEntity<>("Historique medical with id " + historiqueMedicalId + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Historique medical with id " + historiqueMedicalId + " cannot be deleted because it is associated with other entities.", HttpStatus.BAD_REQUEST);
        }
    }

}