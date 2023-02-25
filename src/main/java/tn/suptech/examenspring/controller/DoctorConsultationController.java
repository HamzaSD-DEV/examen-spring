package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.DoctorConsultation;
import tn.suptech.examenspring.service.DoctorConsultationService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor-consultations")
public class DoctorConsultationController {

    @Autowired
    private DoctorConsultationService doctorConsultationService;

    @PostMapping("/add")
    public ResponseEntity<DoctorConsultation> addDoctorConsultation(@RequestBody DoctorConsultation doctorConsultation) {
        DoctorConsultation newDoctorConsultation = doctorConsultationService.addDoctorConsultation(doctorConsultation);
        return new ResponseEntity<>(newDoctorConsultation, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<DoctorConsultation>> getAllDoctorConsultations() {
        List<DoctorConsultation> doctorConsultations = doctorConsultationService.getAllDoctorConsultations();
        return new ResponseEntity<>(doctorConsultations, HttpStatus.OK);
    }

    @GetMapping("/{doctorConsultationId}")
    public ResponseEntity<DoctorConsultation> getDoctorConsultationById(@PathVariable Long doctorConsultationId) throws Exception {
        DoctorConsultation doctorConsultation = doctorConsultationService.getDoctorConsultationById(doctorConsultationId);
        return new ResponseEntity<>(doctorConsultation, HttpStatus.OK);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<DoctorConsultation>> getDoctorConsultationsByPatientId(@PathVariable Long patientId) {
        List<DoctorConsultation> doctorConsultations = doctorConsultationService.getDoctorConsultationsByPatientId(patientId);
        return new ResponseEntity<>(doctorConsultations, HttpStatus.OK);
    }

    @GetMapping("/date/{consultationDate}")
    public ResponseEntity<List<DoctorConsultation>> getDoctorConsultationByConsultationDate(@PathVariable LocalDate consultationDate) {
        List<DoctorConsultation> doctorConsultations = doctorConsultationService.getDoctorConsultationByConsultationDate(consultationDate);
        return new ResponseEntity<>(doctorConsultations, HttpStatus.OK);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<DoctorConsultation>> getDoctorConsultationsByMedicalStaffId(@PathVariable("doctorId") Long medicalStaffId) {
        List<DoctorConsultation> doctorConsultations = doctorConsultationService.getDoctorConsultationsByMedicalStaffId(medicalStaffId);
        return new ResponseEntity<>(doctorConsultations, HttpStatus.OK);
    }

    @PutMapping("/{doctorConsultationId}")
    public ResponseEntity<DoctorConsultation> updateDoctorConsultation(@PathVariable Long doctorConsultationId, @RequestBody DoctorConsultation doctorConsultationDetails) throws Exception {
        DoctorConsultation updatedDoctorConsultation = doctorConsultationService.updateDoctorConsultation(doctorConsultationId, doctorConsultationDetails);
        return new ResponseEntity<>(updatedDoctorConsultation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{doctorConsultationId}")
    public ResponseEntity<String> deleteDoctorConsultation(@PathVariable Long doctorConsultationId) {
        boolean result = doctorConsultationService.deleteDoctorConsultation(doctorConsultationId);
        if (result) {
            return new ResponseEntity<>("Doctor consultation has been deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete doctor consultation.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
