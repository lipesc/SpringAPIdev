package com.github.lipesc.springapidev.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private Long cnpj;

  private String name;
  private double amount;
  private double interest;

  public Company() {}

  @OneToMany(mappedBy = "company")
  private List<Client> clients;

  public Company(
    Long id,
    Long cnpj,
    String name,
    double amount,
    double interest
  ) {
    this.id = id;
    this.cnpj = cnpj;
    this.name = name;
    this.amount = amount;
    this.interest = interest;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCnpj() {
    return cnpj;
  }

  public void setCnpj(Long cnpj) {
    String cnpjString = String.valueOf(cnpj);
    if (cnpjString.length() != 14) {
      throw new IllegalArgumentException("CNPJ must have 14 digits");
    }
    this.cnpj = cnpj;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getamount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public double getinterest() {
    return interest;
  }

  public void setinterest(double interest) {
    this.interest = interest;
  }
}
