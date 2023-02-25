package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.Pharmacie;
import tn.suptech.examenspring.service.PharmacieService;

import java.util.List;

@RestController
@RequestMapping("/pharmacies")
public class PharmacieController {

    @Autowired
    private PharmacieService pharmacieService;

    @PostMapping("")
    public ResponseEntity<Pharmacie> addPharmacie(@RequestBody Pharmacie pharmacie) {
        Pharmacie newPharmacie = pharmacieService.addPharmacie(pharmacie);
        return new ResponseEntity<>(newPharmacie, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Pharmacie>> getAllPharmacies() {
        List<Pharmacie> pharmacies = pharmacieService.getAllPharmacies();
        return new ResponseEntity<>(pharmacies, HttpStatus.OK);
    }

    @GetMapping("/{pharmacieId}")
    public ResponseEntity<Pharmacie> getPharmacieById(@PathVariable Long pharmacieId) throws ResourceNotFoundException {
        Pharmacie pharmacie = pharmacieService.getPharmacieById(pharmacieId);
        return new ResponseEntity<>(pharmacie, HttpStatus.OK);
    }

    @PutMapping("/{pharmacieId}")
    public ResponseEntity<Pharmacie> updatePharmacie(@PathVariable Long pharmacieId, @RequestBody Pharmacie pharmacieDetails) throws ResourceNotFoundException {
        Pharmacie updatedPharmacie = pharmacieService.updatePharmacie(pharmacieId, pharmacieDetails);
        return new ResponseEntity<>(updatedPharmacie, HttpStatus.OK);
    }

    @DeleteMapping("/{pharmacieId}")
    public ResponseEntity<Void> deletePharmacie(@PathVariable Long pharmacieId) throws ResourceNotFoundException {
        boolean isDeleted = pharmacieService.deletePharmacie(pharmacieId);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
