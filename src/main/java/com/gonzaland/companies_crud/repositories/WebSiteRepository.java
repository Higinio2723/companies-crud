package com.gonzaland.companies_crud.repositories;

import com.gonzaland.companies_crud.entities.Company;
import com.gonzaland.companies_crud.entities.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSiteRepository extends JpaRepository<WebSite, Long> {


}
