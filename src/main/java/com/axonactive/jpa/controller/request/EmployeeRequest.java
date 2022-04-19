package com.axonactive.jpa.controller.request;

import com.axonactive.jpa.enumerate.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Setter
@Getter
@ToString
public class EmployeeRequest {
    @NotNull
    private int departmentId;
    @NotNull
    protected String firstName;
    @NotNull
    protected String middleName;
    @NotNull
    protected String lastName;
    @Past
    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "date_of_birth", nullable = false)
    protected LocalDate dateOfBirth;
    @NotNull
    protected Gender gender;
    @NotNull
    protected double salary;
}
