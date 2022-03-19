package com.openclassrooms.mediscreen.model;

import com.openclassrooms.mediscreen.validation.GenderConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    @Past
    private LocalDate dateOfBirth;

    @GenderConstraint(message = "Gender must be M(MALE) or F(FEMALE)")
    private String gender;

    private String address;

    private String phone;
}

