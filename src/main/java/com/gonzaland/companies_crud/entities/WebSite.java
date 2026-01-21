package com.gonzaland.companies_crud.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@Entity
@Table(name = "web_site")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebSite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 32, nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "category")
    @Enumerated(value = EnumType.STRING)
    private String category;

    @Column(columnDefinition = "text")
    private String description;

}
