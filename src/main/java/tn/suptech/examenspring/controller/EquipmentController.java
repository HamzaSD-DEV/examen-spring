package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.Equipment;
import tn.suptech.examenspring.service.EquipmentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/")
    public ResponseEntity<List<Equipment>> getAllEquipment() {
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        return new ResponseEntity<>(equipmentList, HttpStatus.OK);
    }

    @GetMapping("/{equipmentId}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable Long equipmentId) throws Exception {
        Equipment equipment = equipmentService.getEquipmentById(equipmentId);
        return new ResponseEntity<>(equipment, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Equipment>> getEquipmentByName(@PathVariable String name) {
        List<Equipment> equipmentList = equipmentService.getEquipmentByName(name);
        return new ResponseEntity<>(equipmentList, HttpStatus.OK);
    }

    @GetMapping("/serialNumber/{serialNumber}")
    public ResponseEntity<List<Equipment>> getEquipmentBySerialNumber(@PathVariable String serialNumber) {
        List<Equipment> equipmentList = equipmentService.getEquipmentBySerialNumber(serialNumber);
        return new ResponseEntity<>(equipmentList, HttpStatus.OK);
    }

    @GetMapping("/fournisseur/{fournisseur}")
    public ResponseEntity<List<Equipment>> getEquipmentByFournisseur(@PathVariable String fournisseur) {
        List<Equipment> equipmentList = equipmentService.getEquipmentByFournisseur(fournisseur);
        return new ResponseEntity<>(equipmentList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Equipment> addEquipment(@RequestBody Equipment equipment) {
        Equipment addedEquipment = equipmentService.addEquipment(equipment);
        return new ResponseEntity<>(addedEquipment, HttpStatus.CREATED);
    }

    @PutMapping("/update/{equipmentId}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable Long equipmentId, @RequestBody Equipment equipmentDetails) throws Exception {
        Equipment updatedEquipment = equipmentService.updateEquipment(equipmentId, equipmentDetails);
        return new ResponseEntity<>(updatedEquipment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{equipmentId}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Long equipmentId) throws Exception {
        equipmentService.deleteEquipment(equipmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
