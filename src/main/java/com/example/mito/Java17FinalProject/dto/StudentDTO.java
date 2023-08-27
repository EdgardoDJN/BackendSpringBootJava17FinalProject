package com.example.mito.Java17FinalProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {
    private Integer idStudent;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String firstNameStudent;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String lastNameStudent;

    @Min(1)
    @Positive
    private Integer dniStudent;

    @Min(1)
    @Positive
    private Integer ageStudent;
}
