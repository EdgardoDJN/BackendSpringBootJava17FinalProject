package com.example.mito.Java17FinalProject.controller;

import com.example.mito.Java17FinalProject.dto.RegistrationDetailDTO;
import com.example.mito.Java17FinalProject.entity.RegistrationDetail;
import com.example.mito.Java17FinalProject.service.IRegistrationDetailService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrationDetails")
public class RegistrationDetailController {

    private final IRegistrationDetailService service;
    private final ModelMapper mapper;

    @Autowired
    public RegistrationDetailController(IRegistrationDetailService service, @Qualifier("defaultMapper") ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<RegistrationDetailDTO>> readAll() throws Exception {
        List<RegistrationDetailDTO> list = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegistrationDetailDTO> create(@Valid @RequestBody RegistrationDetailDTO dto) throws Exception{
        RegistrationDetail obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistrationDetailDTO> update(@PathVariable("id") Integer id, @RequestBody RegistrationDetailDTO dto) throws Exception{
        dto.setIdRegistrationDetail(id);
        RegistrationDetail obj = service.update(convertToEntity(dto),id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception
    {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    ////////////////////////
    private RegistrationDetailDTO convertToDto(RegistrationDetail obj)
    {
        return mapper.map(obj, RegistrationDetailDTO.class);
    }
    private RegistrationDetail convertToEntity(RegistrationDetailDTO dto)
    {
        return mapper.map(dto, RegistrationDetail.class);
    }
}
