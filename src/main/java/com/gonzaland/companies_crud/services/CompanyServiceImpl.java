package com.gonzaland.companies_crud.services;

import com.gonzaland.companies_crud.entities.Company;
import com.gonzaland.companies_crud.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.Optional;


public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company create(Company company) {
        return companyRepository.save(company);
    }


    @Override
    public Company readByName(String name) {
        Optional<Company> companyOptional = companyRepository.findByName(name);
        if (companyOptional.isEmpty()) {
            return null;
        }

        return companyOptional.get();
    }



    @Override
    public Company update(Company company, String name) {
        return null;
    }

    @Override
    public void delete(String name) {

    }
}
