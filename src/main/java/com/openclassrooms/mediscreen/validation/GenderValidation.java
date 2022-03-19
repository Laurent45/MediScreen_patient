package com.openclassrooms.mediscreen.validation;

import com.openclassrooms.mediscreen.enumeration.Gender;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class GenderValidation implements ConstraintValidator<GenderConstraint
        , String> {

    @Override
    public void initialize(GenderConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Arrays
                .stream(Gender.values())
                .anyMatch(gender -> gender.getSymbol().equals(value));
    }
}
