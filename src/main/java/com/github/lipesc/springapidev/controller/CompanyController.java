package com.github.lipesc.springapidev.controller;

import com.github.lipesc.springapidev.entity.Company;
import com.github.lipesc.springapidev.service.CompanyService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companys")
public class CompanyController {

  @Autowired
  private CompanyService companyService;

  @PostMapping
  public Company createCompany(@RequestBody Company company) {
    return companyService.createCompany(company);
  }

  @GetMapping
  public List<Company> getALLClient() {
    return companyService.getAllCompany();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
    Optional<Company> company = companyService.getCompanyById(id);
    return company
      .map(ResponseEntity::ok)
      .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Company> updateCompany(
    @PathVariable Long id,
    @RequestBody Company companyDetails
  ) {
    Company updatedCompany = companyService.updateCompany(id, companyDetails);
    return ResponseEntity.ok(updatedCompany);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
    companyService.deleteCompany(id);
    return ResponseEntity.noContent().build();
  }
}
