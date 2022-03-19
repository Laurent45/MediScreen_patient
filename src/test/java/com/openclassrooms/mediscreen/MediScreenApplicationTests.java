package com.openclassrooms.mediscreen;

import com.openclassrooms.mediscreen.enumeration.Gender;
import com.openclassrooms.mediscreen.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MediScreenApplicationTests {

    @Test
    void contextLoads() {
    }

}
