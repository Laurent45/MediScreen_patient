package com.openclassrooms.mediscreen.controller;

import com.openclassrooms.mediscreen.model.Patient;
import com.openclassrooms.mediscreen.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {

    private final IPatientService patientService;

    @GetMapping("/list")
    public List<Patient> getPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return patientService.getPatient(id);
    }

    @PostMapping("/save")
    public ResponseEntity<String> savePatient(@RequestBody @Valid Patient patient) {
        Patient patientSaved = patientService.savePatient(patient);
        return ResponseEntity
                .created(URI.create("/patient/" + patientSaved.getId())).build();
    }

    @PutMapping("/update/{id}")
    public Patient updatePatient(@PathVariable("id") Long id,
                                 @RequestBody @Valid Patient patient) {
        return patientService.updatePatient(id, patient);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
    }
}
