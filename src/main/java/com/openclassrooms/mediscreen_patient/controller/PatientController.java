package com.openclassrooms.mediscreen_patient.controller;

import com.openclassrooms.mediscreen_patient.model.Patient;
import com.openclassrooms.mediscreen_patient.service.IPatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
@Api(tags = "CRUD operations about patient information")
public class PatientController {

    private final IPatientService patientService;

    @ApiOperation("Get all patient")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All patient return")
    })
    @GetMapping("/list")
    public List<Patient> getPatients() {
        return patientService.getAllPatients();
    }

    @ApiOperation("Get a patient by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return a patient by id"),
            @ApiResponse(code = 404, message = "Patient doesn't exist")
    })
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return patientService.getPatient(id);
    }

    @ApiOperation("Create a new patient")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "A patient created"),
            @ApiResponse(code = 400, message = "Some fields are not valid")
    })
    @PostMapping("/save")
    public ResponseEntity<String> savePatient(@RequestBody @Valid Patient patient) {
        Patient patientSaved = patientService.savePatient(patient);
        return ResponseEntity
                .created(URI.create("/patient/" + patientSaved.getId())).build();
    }

    @ApiOperation("Update a patient")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A patient updated"),
            @ApiResponse(code = 400, message = "Some fields are not valid"),
            @ApiResponse(code = 404, message = "Patient doesn't exist")
    })
    @PutMapping("/update/{id}")
    public Patient updatePatient(@PathVariable("id") Long id,
                                 @RequestBody @Valid Patient patient) {
        return patientService.updatePatient(id, patient);
    }

    @ApiOperation("Delete a patient")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A patient deleted"),
            @ApiResponse(code = 404, message = "Patient doesn't exist")
    })
    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
    }
}
