package com.gonzaland.companies_crud.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "foundation_date")
    private LocalDate foundationDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = {CascadeType.MERGE, CascadeType.PERSIST,
    CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name="id_company", referencedColumnName = "id")
    private List<WebSite> webSites;
}
