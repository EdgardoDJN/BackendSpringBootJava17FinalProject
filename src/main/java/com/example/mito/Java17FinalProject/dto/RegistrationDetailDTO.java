package com.example.mito.Java17FinalProject.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationDetailDTO {

    private Integer idRegistrationDetail;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 45)
    private String aula;

    @JsonIncludeProperties(value = {"idCourse"})
    @NotNull
    private CourseDTO course;

    @JsonBackReference
    private RegistrationDTO registration;
}
