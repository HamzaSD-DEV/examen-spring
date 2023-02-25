package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.Fournisseur;
import tn.suptech.examenspring.service.FournisseurService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fournisseurs")
public class FournisseurController {
    @Autowired
    private FournisseurService fournisseurService;

    @PostMapping("/add")
    public ResponseEntity<Fournisseur> addFournisseur(@RequestBody Fournisseur fournisseur) {
        Fournisseur createdFournisseur = fournisseurService.addFournisseur(fournisseur);
        return new ResponseEntity<>(createdFournisseur, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Fournisseur>> getAllFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurService.getAllFournisseurs();
        return new ResponseEntity<>(fournisseurs, HttpStatus.OK);
    }

    @GetMapping("/{fournisseurId}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable Long fournisseurId) throws Exception {
        Fournisseur fournisseur = fournisseurService.getFournisseurById(fournisseurId);
        return new ResponseEntity<>(fournisseur, HttpStatus.OK);
    }

    @PutMapping("/update/{fournisseurId}")
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable Long fournisseurId, @RequestBody Fournisseur fournisseurDetails) throws Exception {
        Fournisseur updatedFournisseur = fournisseurService.updateFournisseur(fournisseurId, fournisseurDetails);
        return new ResponseEntity<>(updatedFournisseur, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{fournisseurId}")
    public ResponseEntity<String> deleteFournisseur(@PathVariable Long fournisseurId) {
        try {
            boolean isDeleted = fournisseurService.deleteFournisseur(fournisseurId);
            if (isDeleted) {
                return new ResponseEntity<>("Fournisseur with id " + fournisseurId + " has been deleted.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Fournisseur with id " + fournisseurId + " does not exist.", HttpStatus.NOT_FOUND);
            }
        } catch (DataIntegrityViolationException ex) {
            return new ResponseEntity<>("Cannot delete fournisseur with id " + fournisseurId + " because it is associated with other entities.", HttpStatus.BAD_REQUEST);
        }
    }

}