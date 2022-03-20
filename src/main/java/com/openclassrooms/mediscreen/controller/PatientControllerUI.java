package com.openclassrooms.mediscreen.controller;

import com.openclassrooms.mediscreen.model.Patient;
import com.openclassrooms.mediscreen.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("ui/patient")
@RequiredArgsConstructor
public class PatientControllerUI {

    private final IPatientService patientService;

    private static final String REDIRECT_INDEX = "redirect:/ui/patient/";

    @GetMapping("/")
    public String getIndex(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "index";
    }

    @GetMapping("/create")
    public String getCreatePatient(Model model) {
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "create";
    }

    @PostMapping("/create")
    public String createPatient(RedirectAttributes redirectAttributes
            , @Valid Patient patient
            , BindingResult result) {
        if (result.hasErrors()) {
            return "create";
        }
        patientService.savePatient(patient);
        String message =
                "Created user <b>" + patient.getFirstName() + " " + patient.getLastName() + "</b> ✨.";
        redirectAttributes.addFlashAttribute("patientCreated", message);
        return REDIRECT_INDEX;
    }

    @GetMapping("/update/{id}")
    public String getPatient(Model model, @PathVariable("id") Long id) {
        Patient patient = patientService.getPatient(id);
        model.addAttribute("patient", patient);
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updatePatient(RedirectAttributes redirectAttributes
            , @PathVariable("id") Long id
            , @Valid Patient patient
            , BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }
        patientService.updatePatient(id, patient);
        String message =
                "Updated  patient <b>" + patient.getFirstName() + " " + patient.getLastName() + "</b>.";
        redirectAttributes.addFlashAttribute("patientUpdated", message);
        return REDIRECT_INDEX;
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") Long id,
                                RedirectAttributes redirectAttributes) {
        patientService.deletePatient(id);
        String message = "Delete patient <b>" + id + "</b>.";
        redirectAttributes.addFlashAttribute("patientDeleted", message);
        return REDIRECT_INDEX;
    }

}
