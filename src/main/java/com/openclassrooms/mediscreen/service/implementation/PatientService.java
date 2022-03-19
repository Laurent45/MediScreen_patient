package com.openclassrooms.mediscreen.service.implementation;

import com.openclassrooms.mediscreen.exception.IdPatientException;
import com.openclassrooms.mediscreen.model.Patient;
import com.openclassrooms.mediscreen.repository.PatientRepository;
import com.openclassrooms.mediscreen.service.IPatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class PatientService implements IPatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        log.info("Get all patient");
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatient(Long id) {
        log.info("Get a patient by id: " + id);
        return getPatientById(id);
    }

    @Override
    public Patient savePatient(Patient patient) {
        log.info("Save a patient: " + patient);
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        log.info("Update a patient: " + patient);
        Patient patientToUpdate = getPatientById(id);

        if (patient.getFirstName() != null) {
            patientToUpdate.setFirstName(patient.getFirstName());
        }
        if (patient.getLastName() != null) {
            patientToUpdate.setLastName(patient.getLastName());
        }
        if (patient.getDateOfBirth() != null) {
            patientToUpdate.setDateOfBirth(patient.getDateOfBirth());
        }
        if (patient.getGender() != null) {
            patientToUpdate.setGender(patient.getGender());
        }
        if (patient.getAddress() != null) {
            patientToUpdate.setAddress(patient.getAddress());
        }
        if (patient.getPhone() != null) {
            patientToUpdate.setPhone(patient.getPhone());
        }

        return patientRepository.save(patientToUpdate);
    }

    @Override
    public void deletePatient(Long id) {
        log.info("Delete a patient, id: " + id);
        Patient patient = getPatientById(id);
        patientRepository.delete(patient);
    }

    private Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new IdPatientException(String.format(
                        "Patient id: %d doesn't exist", id)));
    }
}
