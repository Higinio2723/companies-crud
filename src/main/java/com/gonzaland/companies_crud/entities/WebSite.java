package com.gonzaland.companies_crud.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "web_site")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_company", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    @Column(name = "name", length = 32, nullable = false, unique = true)
    private String name;

    @Column(length = 32, nullable = false)
    private String category;

    @Column(columnDefinition = "text")
    private String description;

}
