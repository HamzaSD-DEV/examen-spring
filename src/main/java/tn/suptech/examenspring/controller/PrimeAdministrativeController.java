package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.PrimeAdministrative;
import tn.suptech.examenspring.service.PrimeAdministrativeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prime-administratives")
public class PrimeAdministrativeController {

    @Autowired
    private PrimeAdministrativeService primeAdministrativeService;

    @PostMapping("/add")
    public ResponseEntity<PrimeAdministrative> addPrimeAdministrative(@RequestBody PrimeAdministrative primeAdministrative) {
        PrimeAdministrative addedPrimeAdministrative = primeAdministrativeService.save(primeAdministrative);
        return new ResponseEntity<>(addedPrimeAdministrative, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<PrimeAdministrative>> getAllPrimeAdministratives() {
        List<PrimeAdministrative> primeAdministratives = primeAdministrativeService.findAll();
        return new ResponseEntity<>(primeAdministratives, HttpStatus.OK);
    }

    @GetMapping("/{primeAdministrativeId}")
    public ResponseEntity<PrimeAdministrative> getPrimeAdministrativeById(@PathVariable Long primeAdministrativeId) throws ResourceNotFoundException {
        PrimeAdministrative primeAdministrative = primeAdministrativeService.findById(primeAdministrativeId);
        return new ResponseEntity<>(primeAdministrative, HttpStatus.OK);
    }

    @PutMapping("/update/{primeAdministrativeId}")
    public ResponseEntity<PrimeAdministrative> updatePrimeAdministrative(@PathVariable Long primeAdministrativeId, @RequestBody PrimeAdministrative primeAdministrativeDetails) throws ResourceNotFoundException {
        PrimeAdministrative updatedPrimeAdministrative = primeAdministrativeService.update(primeAdministrativeId, primeAdministrativeDetails);
        return new ResponseEntity<>(updatedPrimeAdministrative, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{primeAdministrativeId}")
    public ResponseEntity<Void> deletePrimeAdministrative(@PathVariable Long primeAdministrativeId) throws ResourceNotFoundException {
        primeAdministrativeService.deleteById(primeAdministrativeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
