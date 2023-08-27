package com.example.mito.Java17FinalProject.controller;

import com.example.mito.Java17FinalProject.dto.RegistrationDTO;
import com.example.mito.Java17FinalProject.entity.Registration;
import com.example.mito.Java17FinalProject.service.IRegistrationService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
    private final IRegistrationService service;
    private final ModelMapper mapper;

    @Autowired
    public RegistrationController(IRegistrationService service, @Qualifier("defaultMapper") ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    @PostMapping
    public ResponseEntity<RegistrationDTO> create(@Valid @RequestBody RegistrationDTO dto) throws Exception{
        Registration registration = convertToEntity(dto);
        Registration obj = service.save(registration);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
    }
    ////////////////////////
    private RegistrationDTO convertToDto(Registration obj)
    {
        return mapper.map(obj, RegistrationDTO.class);
    }
    private Registration convertToEntity(RegistrationDTO dto)
    {
        return mapper.map(dto, Registration.class);
    }
}
