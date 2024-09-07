package com.github.lipesc.tgidjavadeveloper.empresa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Empresa {

  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String cnpj;

  private String nome;
  private double saldo;
  private double receberDeposito;
  private double taxaSaque;

  public Empresa(
    Long id,
    String cnpj,
    String nome,
    double saldo,
    double receberDeposito,
    double taxaSaque
  ) {
    this.id = id;
    this.cnpj = cnpj;
    this.nome = nome;
    this.saldo = saldo;
    this.taxaSaque = taxaSaque;
    this.receberDeposito = receberDeposito;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public double getTaxaSaque() {
    return taxaSaque;
  }

  public void setTaxaSaque(double taxaSaque) {
    this.taxaSaque = taxaSaque;
  }

  public double getDeposito() {
    return receberDeposito;
  }

  public void setDeposito(double receberDeposito) {
    this.receberDeposito = receberDeposito;
  }
}
