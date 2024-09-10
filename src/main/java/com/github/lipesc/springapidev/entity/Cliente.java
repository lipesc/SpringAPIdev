package com.github.lipesc.springapidev.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String cpf;

  private String nome;
  private double saldo;

  public Cliente() {}

  public Cliente(Long id, String cpf, String nome, double saldo) {
    this.id = id;
    this.cpf = cpf;
    this.nome = nome;
    this.saldo = saldo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
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

  public boolean isValidCPF() {
    String cpf = getCpf();
    if (cpf == null || cpf.length() != 11) {
      return false;
    }
    for (char c : cpf.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }
}
