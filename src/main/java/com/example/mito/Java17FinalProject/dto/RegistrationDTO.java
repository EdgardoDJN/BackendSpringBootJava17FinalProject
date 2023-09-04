package com.example.mito.Java17FinalProject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationDTO {

    private Integer idRegistration;

    @NotNull
    private Boolean state;

    @NotNull
    private LocalDateTime dateOfRegistration;

    @NotNull
    private StudentDTO student;


    @JsonManagedReference
    @NotNull
    private List<RegistrationDetailDTO> registrationDetail;
}
