package com.example.mito.Java17FinalProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "registration")
@Getter
@Setter
@NoArgsConstructor
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registration", nullable = false)
    private Integer idRegistration;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean state;

    @Column(name="date_of_registration",nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dateOfRegistration;

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id_student")
    private Student student;

    //cascade = CascadeType.ALL me permite la inserción de las dos tablas
    @OneToMany(mappedBy = "registration",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<RegistrationDetail> registrationDetail;
}
