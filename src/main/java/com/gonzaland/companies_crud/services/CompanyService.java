package com.gonzaland.companies_crud.services;

import com.gonzaland.companies_crud.entities.Company;

import java.util.List;

public interface CompanyService {

    Company readByName(String name);

    Company create(Company company);

    Company update(Company company, String name);

    void delete(String name);

    List<Company> readAll();
}
