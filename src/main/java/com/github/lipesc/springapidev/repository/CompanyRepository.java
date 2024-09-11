package com.github.lipesc.springapidev.repository;

import com.github.lipesc.springapidev.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {}
