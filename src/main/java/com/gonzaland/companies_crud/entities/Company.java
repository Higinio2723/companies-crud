package com.gonzaland.companies_crud.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "company")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 32, nullable = false, unique = true)
    private String name;

    @Column(length = 128)
    private String founder;

    @Column(length = 255)
    private String logo;

    @Column(name = "foundation_date")
    private LocalDate foundationDate;

}
