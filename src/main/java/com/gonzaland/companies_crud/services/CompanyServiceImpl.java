package com.gonzaland.companies_crud.services;

import com.gonzaland.companies_crud.entities.Category;
import com.gonzaland.companies_crud.entities.Company;
import com.gonzaland.companies_crud.repositories.CompanyRepository;

import io.micrometer.tracing.Tracer;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.io.ObjectStreamClass;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    private final Tracer tracer;


    @Override
    public Company create(Company company) {
        log.info("###################### Creating company: {}", company.getName());
        company.getWebSites().forEach(webSite -> {
                    if (Objects.isNull(webSite.getCategory())) {
                        webSite.setCategory(Category.NONE);
                    }
                }
        );
   return companyRepository.save(company);

    }


    @Override
    public Company readByName(String name) {
        var spam = tracer.nextSpan().name("read-company-by-name");
        try{Tracer.SpanInScope spanInScope = tracer.withSpan(spam.start());
            log.info("###################### Reading company by name: {}", name);

        } finally {
            spam.end();
        }

        return companyRepository.findByName(name)
                .orElseThrow(()-> new RuntimeException("Company not found"));
    }



    @Override
    public Company update(Company company, String name) {
        Company companyToUpdate = companyRepository.findByName(name)
                .orElseThrow(()-> new RuntimeException("Company not found"));

        companyToUpdate.setLogo(company.getLogo());
        companyToUpdate.setFoundationDate(company.getFoundationDate());
        companyToUpdate.setFounder(company.getFounder());

        return companyRepository.save(companyToUpdate);
    }

    /**
     * Delete a company by its name
     * @param name
     */
    @Override
    public void delete(String name) {
        Company companyToDelete = companyRepository.findByName(name)
                .orElseThrow(()-> new RuntimeException("Company not found"));

        companyRepository.delete(companyToDelete);
    }

    @Override
    public List<Company> readAll() {
        return companyRepository.findAll();
    }


}
