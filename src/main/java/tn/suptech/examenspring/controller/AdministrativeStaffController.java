package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.AdministrativeStaff;
import tn.suptech.examenspring.service.AdministrativeStaffService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/administrative-staff")
public class AdministrativeStaffController {

    @Autowired
    private AdministrativeStaffService administrativeStaffService;

    @PostMapping("/add")
    public ResponseEntity<AdministrativeStaff> addAdministrativeStaff(@RequestBody AdministrativeStaff administrativeStaff) {
        AdministrativeStaff newAdministrativeStaff = administrativeStaffService.addAdministrativeStaff(administrativeStaff);
        return new ResponseEntity<>(newAdministrativeStaff, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<AdministrativeStaff>> getAllAdministrativeStaff() {
        List<AdministrativeStaff> administrativeStaffList = administrativeStaffService.getAllAdministrativeStaff();
        return new ResponseEntity<>(administrativeStaffList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministrativeStaff> getAdministrativeStaffById(@PathVariable("id") Long administrativeStaffId) throws Exception {
        AdministrativeStaff administrativeStaff = administrativeStaffService.getAdministrativeStaffById(administrativeStaffId);
        return new ResponseEntity<>(administrativeStaff, HttpStatus.OK);
    }

    @GetMapping("/cin/{cinNumber}")
    public ResponseEntity<AdministrativeStaff> getAdministrativeStaffByCinNumber(@PathVariable("cinNumber") Long cinNumber) throws Exception {
        AdministrativeStaff administrativeStaff = administrativeStaffService.getAdministrativeStaffByCinNumber(cinNumber);
        return new ResponseEntity<>(administrativeStaff, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AdministrativeStaff> updateAdministrativeStaff(@PathVariable("id") Long administrativeStaffId,
                                                                         @RequestBody AdministrativeStaff administrativeStaffDetails) throws Exception {
        AdministrativeStaff updatedAdministrativeStaff = administrativeStaffService.updateAdministrativeStaff(administrativeStaffId, administrativeStaffDetails);
        return new ResponseEntity<>(updatedAdministrativeStaff, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteAdministrativeStaff(@PathVariable("id") Long administrativeStaffId) {
        boolean deleted = administrativeStaffService.deleteAdministrativeStaff(administrativeStaffId);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
