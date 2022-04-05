package com.openclassrooms.mediscreen_patient.model;

import com.openclassrooms.mediscreen_patient.validation.GenderConstraint;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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
    @ApiModelProperty(hidden = true)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    @Past(message = "the date must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(notes = "the date must be in the past")
    private LocalDate dateOfBirth;

    @GenderConstraint(message = "Gender must be M(MALE) or F(FEMALE)")
    @ApiModelProperty(example = "M|F")
    private String gender;

    private String address;

    private String phone;
}

