package com.example.mito.Java17FinalProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course", nullable = false)
    private Integer idCourse;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false,length = 45)
    private String acronym;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean state;
}
