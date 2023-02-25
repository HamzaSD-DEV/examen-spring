package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.OperatingBloc;
import tn.suptech.examenspring.service.OperatingBlocService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/operating-blocs")
public class OperatingBlocController {
    @Autowired
    private OperatingBlocService operatingBlocService;

    @GetMapping("/")
    public ResponseEntity<List<OperatingBloc>> getAllOperatingBlocs() {
        List<OperatingBloc> operatingBlocs = operatingBlocService.getAllOperatingBlocs();
        return new ResponseEntity<>(operatingBlocs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperatingBloc> getOperatingBlocById(@PathVariable("id") Long operatingBlocId) throws Exception {
        OperatingBloc operatingBloc = operatingBlocService.getOperatingBlocById(operatingBlocId);
        return new ResponseEntity<>(operatingBloc, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<OperatingBloc> addOperatingBloc(@RequestBody OperatingBloc operatingBloc) {
        OperatingBloc newOperatingBloc = operatingBlocService.addOperatingBloc(operatingBloc);
        return new ResponseEntity<>(newOperatingBloc, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OperatingBloc> updateOperatingBloc(@PathVariable("id") Long operatingBlocId, @RequestBody OperatingBloc operatingBlocDetails) {
        try {
            OperatingBloc updatedOperatingBloc = operatingBlocService.updateOperatingBloc(operatingBlocId, operatingBlocDetails);
            return new ResponseEntity<>(updatedOperatingBloc, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteOperatingBloc(@PathVariable("id") Long operatingBlocId) {
        try {
            boolean result = operatingBlocService.deleteOperatingBloc(operatingBlocId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
