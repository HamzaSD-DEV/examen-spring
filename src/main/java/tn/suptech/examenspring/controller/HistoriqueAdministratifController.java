package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.HistoriqueAdministratif;
import tn.suptech.examenspring.service.HistoriqueAdministratifService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/historique-administratif")
public class HistoriqueAdministratifController {
    @Autowired
    private HistoriqueAdministratifService historiqueAdministratifService;

    @PostMapping("/add")
    public ResponseEntity<HistoriqueAdministratif> addHistoriqueAdministratif(@RequestBody HistoriqueAdministratif historiqueAdministratif) {
        HistoriqueAdministratif newHistoriqueAdministratif = historiqueAdministratifService.addHistoriqueAdministratif(historiqueAdministratif);
        return new ResponseEntity<>(newHistoriqueAdministratif, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<HistoriqueAdministratif>> getAllHistoriqueAdministratifs() {
        List<HistoriqueAdministratif> historiqueAdministratifList = historiqueAdministratifService.getAllHistoriqueAdministratifs();
        return new ResponseEntity<>(historiqueAdministratifList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriqueAdministratif> getHistoriqueAdministratifById(@PathVariable("id") Long historiqueAdministratifId) throws Exception {
        HistoriqueAdministratif historiqueAdministratif = historiqueAdministratifService.getHistoriqueAdministratifById(historiqueAdministratifId);
        return new ResponseEntity<>(historiqueAdministratif, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HistoriqueAdministratif> updateHistoriqueAdministratif(@PathVariable("id") Long historiqueAdministratifId,
                                                                                 @RequestBody HistoriqueAdministratif historiqueAdministratifDetails) throws Exception {
        HistoriqueAdministratif updatedHistoriqueAdministratif = historiqueAdministratifService.updateHistoriqueAdministratif(historiqueAdministratifId, historiqueAdministratifDetails);
        return new ResponseEntity<>(updatedHistoriqueAdministratif, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteHistoriqueAdministratif(@PathVariable("id") Long historiqueAdministratifId) {
        boolean deleted = historiqueAdministratifService.deleteHistoriqueAdministratif(historiqueAdministratifId);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}