package com.gonzaland.companies_crud.controllers;

import com.gonzaland.companies_crud.entities.Company;
import com.gonzaland.companies_crud.services.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/company")
@Slf4j
@Tag(name = "Companies resource")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/{name}")
    @Operation(summary = "Get company by name")
    public ResponseEntity<Company> getCompanyByName(@PathVariable String name) {
        log.info("Getting company by name: {}", name);
        return ResponseEntity.ok(companyService.readByName(name));
    }

    @PostMapping
    @Operation(summary = "Create a new company")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        log.info("Creating company: {}", company);
        return ResponseEntity.ok(companyService.create(company));
    }

    @PutMapping("/{name}")
    @Operation(summary = "Update company by name")
    public ResponseEntity<Company> updateCompany(@PathVariable String name, @RequestBody Company company) {
        log.info("Updating company: {}", name);
        return ResponseEntity.ok(companyService.update(company, name));
    }

    @DeleteMapping("/{name}")
    @Operation(summary = "Delete company by name")
    public ResponseEntity<Void> deleteCompany(@PathVariable String name) {
        log.info("Deleting company: {}", name);
        companyService.delete(name);
        return ResponseEntity.noContent().build();
    }
}
