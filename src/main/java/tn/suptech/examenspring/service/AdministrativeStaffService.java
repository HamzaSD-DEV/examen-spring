package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.AdministrativeStaff;
import tn.suptech.examenspring.repository.AdministrativeStaffRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrativeStaffService {

    @Autowired
    private AdministrativeStaffRepository administrativeStaffRepository;

    public AdministrativeStaff addAdministrativeStaff(AdministrativeStaff administrativeStaff) {
        return administrativeStaffRepository.save(administrativeStaff);
    }

    public List<AdministrativeStaff> getAllAdministrativeStaff() {
        return administrativeStaffRepository.findAll();
    }

    public AdministrativeStaff getAdministrativeStaffById(Long administrativeStaffId) throws Exception {
        Optional<AdministrativeStaff> administrativeStaff = administrativeStaffRepository.findById(administrativeStaffId);
        if (administrativeStaff.isPresent()) {
            return administrativeStaff.get();
        } else {
            throw new Exception("Administrative staff not found with id " + administrativeStaffId);
        }
    }


    public AdministrativeStaff getAdministrativeStaffByCinNumber(Long cinNumber) throws Exception {
        Optional<AdministrativeStaff> administrativeStaff = administrativeStaffRepository.findByCinNumber(cinNumber);
        if (administrativeStaff.isPresent()) {
            return administrativeStaff.get();
        } else {
            throw new Exception("Administrative staff not found with CIN number " + cinNumber);
        }
    }


    public AdministrativeStaff updateAdministrativeStaff(Long administrativeStaffId, AdministrativeStaff administrativeStaffDetails) throws Exception {
        Optional<AdministrativeStaff> administrativeStaff = administrativeStaffRepository.findById(administrativeStaffId);
        if (administrativeStaff.isPresent()) {
            AdministrativeStaff existingAdministrativeStaff = administrativeStaff.get();
            existingAdministrativeStaff.setCinNumber(administrativeStaffDetails.getCinNumber());
            existingAdministrativeStaff.setFirstName(administrativeStaffDetails.getFirstName());
            existingAdministrativeStaff.setLastName(administrativeStaffDetails.getLastName());
            existingAdministrativeStaff.setSexe(administrativeStaffDetails.getSexe());
            existingAdministrativeStaff.setBirthDate(administrativeStaffDetails.getBirthDate());
            existingAdministrativeStaff.setAddress(administrativeStaffDetails.getAddress());
            existingAdministrativeStaff.setPhoneNumber(administrativeStaffDetails.getPhoneNumber());
            existingAdministrativeStaff.setEmail(administrativeStaffDetails.getEmail());
            existingAdministrativeStaff.setBank(administrativeStaffDetails.getBank());
            existingAdministrativeStaff.setRib(administrativeStaffDetails.getRib());
            existingAdministrativeStaff.setAdmistrativePosition(administrativeStaffDetails.getAdmistrativePosition());
            return administrativeStaffRepository.save(existingAdministrativeStaff);
        } else {
            throw new Exception("Administrative staff not found with id " + administrativeStaffId);
        }
    }

    public boolean deleteAdministrativeStaff(Long administrativeStaffId) {
        try {
            administrativeStaffRepository.deleteById(administrativeStaffId);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Cannot delete administrative staff with id " + administrativeStaffId + " because it is associated with other entities.");
        }

    }
}
