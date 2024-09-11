package com.github.lipesc.springapidev.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private Long cpf;

  private String name;
  private double amount;

  public Client() {}

  
  @ManyToOne
  @JoinColumn(name = "company_id")
  private Company company;

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }
  

  public Client(Long id, Long cpf, String name, double amount) {
    this.id = id;
    this.cpf = cpf;
    this.name = name;
    this.amount = amount;
  }
  

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCpf() {
    return cpf;
  }

  public void setCpf(Long cpf) {
    String cpfString = String.valueOf(cpf);
    if (cpfString.length() != 11) {
      throw new IllegalArgumentException("CPF must have 11 digits.");
    }
    this.cpf = cpf;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }
}
