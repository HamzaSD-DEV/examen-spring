package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.OperationChirurgical;
import tn.suptech.examenspring.service.OperationChirurgicalService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/operation-chirurgicaux")
public class OperationChirurgicalController {
    @Autowired
    private OperationChirurgicalService operationChirurgicalService;

    @GetMapping("/")
    public ResponseEntity<List<OperationChirurgical>> getAllOperationChirurgical() {
        List<OperationChirurgical> operationChirurgicaux = operationChirurgicalService.getAllOperationChirurgical();
        return new ResponseEntity<>(operationChirurgicaux, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationChirurgical> getOperationChirurgicalById(@PathVariable("id") Long operationChirurgicalId) throws Exception {
        OperationChirurgical operationChirurgical = operationChirurgicalService.getOperationChirurgicalById(operationChirurgicalId);
        return new ResponseEntity<>(operationChirurgical, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<OperationChirurgical> addOperationChirurgical(@RequestBody OperationChirurgical operationChirurgical) {
        OperationChirurgical newOperationChirurgical = operationChirurgicalService.addOperationChirurgical(operationChirurgical);
        return new ResponseEntity<>(newOperationChirurgical, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OperationChirurgical> updateOperationChirurgical(@PathVariable("id") Long operationChirurgicalId, @RequestBody OperationChirurgical operationChirurgicalDetails) {
        try {
            OperationChirurgical updatedOperationChirurgical = operationChirurgicalService.updateOperationChirurgical(operationChirurgicalId, operationChirurgicalDetails);
            return new ResponseEntity<>(updatedOperationChirurgical, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteOperationChirurgical(@PathVariable("id") Long operationChirurgicalId) {
        try {
            boolean result = operationChirurgicalService.deleteOperationChirurgical(operationChirurgicalId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}