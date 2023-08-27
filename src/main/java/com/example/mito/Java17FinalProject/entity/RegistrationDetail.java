package com.example.mito.Java17FinalProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "registration_detail")
@Getter
@Setter
@NoArgsConstructor
public class RegistrationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registration_detail", nullable = false)
    private Integer idRegistrationDetail;

    @Column(nullable = false, length = 45)
    private String aula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course", referencedColumnName = "id_course", unique = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "id_registration", referencedColumnName = "id_registration", unique = false)
    private Registration registration;
}
