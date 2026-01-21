package com.gonzaland.companies_crud.services;

import com.gonzaland.companies_crud.entities.Category;
import com.gonzaland.companies_crud.entities.Company;
import com.gonzaland.companies_crud.repositories.CompanyRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.io.ObjectStreamClass;
import java.util.Objects;
import java.util.Optional;


@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company create(Company company) {
        company.getWebSites().forEach(webSite -> {
                    if (Objects.isNull(webSite.getCompany())) {
                        webSite.setCategory(Category.NONE);
                    }
                }
        );

   return companyRepository.save(company);

    }


    @Override
    public Company readByName(String name) {

        return companyRepository.findByName(name)
                .orElseThrow(()-> new RuntimeException("Company not found"));
    }



    @Override
    public Company update(Company company, String name) {
        return null;
    }

    @Override
    public void delete(String name) {

    }
}
