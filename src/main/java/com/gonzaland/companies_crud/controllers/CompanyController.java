package com.gonzaland.companies_crud.controllers;

import com.gonzaland.companies_crud.entities.Company;
import com.gonzaland.companies_crud.services.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/company")
@Slf4j
@Tag(name = "Companies resource")
@Validated
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "Get a company by name")
    @GetMapping("/{name}")
    public ResponseEntity<Company> getCompanyByName(@PathVariable @NotBlank String name) {
        log.info("GET /api/company/{}", name);
        Company company = companyService.readByName(name);
        return ResponseEntity.ok(company);
    }

    @Operation(summary = "Create a new company")
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody @Valid Company company) {
        log.info("POST /api/company");
        Company createdCompany = companyService.create(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompany);
    }

    @Operation(summary = "Update an existing company")
    @PutMapping("/{name}")
    public ResponseEntity<Company> updateCompany(@PathVariable @NotBlank String name, @RequestBody @Valid Company company) {
        log.info("PUT /api/company/{}", name);
        Company updatedCompany = companyService.update(company, name);
        return ResponseEntity.ok(updatedCompany);
    }

    @Operation(summary = "Delete a company by name")
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteCompany(@PathVariable @NotBlank String name) {
        log.info("DELETE /api/company/{}", name);
        companyService.delete(name);
        return ResponseEntity.noContent().build();
    }
}
