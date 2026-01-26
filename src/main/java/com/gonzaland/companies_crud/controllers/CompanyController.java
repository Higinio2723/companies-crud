package com.gonzaland.companies_crud.controllers;

import com.gonzaland.companies_crud.entities.Company;
import com.gonzaland.companies_crud.services.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "company")
@Slf4j
@Tag(name = "Companies resource")
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "get a company given a company name")
    @GetMapping(path = "{name}")
    public ResponseEntity<Company> getCompanyByName(@PathVariable String name) {
        log.info("GET: company: {}", name);
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        Company company = this.companyService.readByName(name);
        return ResponseEntity.ok(company);
    }

    @Operation(summary = "get all company given a company name")
    @GetMapping
    public ResponseEntity<List<Company>> getCompanyAll() {
        List<Company> companies = this.companyService.readAll();
        log.info("GET: companies: {}", companies);
        return ResponseEntity.ok(companies);
    }

    @Operation(summary = "save in DB a company given a company from body")
    @PostMapping
    public ResponseEntity<Company> post(@RequestBody Company company) {
        log.info("POST: company: {}", company.getName());
        Company createdCompany = this.companyService.create(company);
        return ResponseEntity.ok(createdCompany);
    }

    @Operation(summary = "update in DB a company given a company from body")
    @PutMapping(path = "{name}")
    public ResponseEntity<Company> put(@PathVariable String name, @RequestBody Company company) {
        log.info("PUT: company: {}", name);
        Company updatedCompany = this.companyService.update(company, name);
        return ResponseEntity.ok(updatedCompany);
    }

    @Operation(summary = "delete in DB a company given a company name")
    @DeleteMapping(path = "{name}")
    public ResponseEntity<Void> delete(@PathVariable String name) {
        log.info("DELETE: company: {}", name);
        this.companyService.delete(name);
        return ResponseEntity.noContent().build();
    }

}
