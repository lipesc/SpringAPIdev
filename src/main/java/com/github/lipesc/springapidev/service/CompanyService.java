package com.github.lipesc.springapidev.service;

import com.github.lipesc.springapidev.entity.Company;
import com.github.lipesc.springapidev.repository.CompanyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

  @Autowired
  private CompanyRepository companyRepository;

  public Company createCompany(Company company) {
    return companyRepository.save(company);
  }

  public List<Company> getAllCompany() {
    return companyRepository.findAll();
  }

  public Optional<Company> getCompanyById(Long id) {
    return companyRepository.findById(id);
  }

  public Company updateCompany(Long id, Company companyDetails) {
    Company company = companyRepository
      .findById(id)
      .orElseThrow(() -> new RuntimeException("Company not found"));
    company.setName(companyDetails.getName());
    company.setCnpj(companyDetails.getCnpj());
    company.setAmount(companyDetails.getamount());
    company.setinterest(companyDetails.getinterest());
    return companyRepository.save(company);
  }

  public void deleteCompany(Long id) {
    companyRepository.deleteById(id);
  }
}
