package com.github.lipesc.tgidjavadeveloper.cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cliente {

  @Id
  @GeneratedValue
  private Long id;
  @Column(unique = true)
  private String cpf;

  private String nome;
  private double saldo;
  private double deposito;
  private double saque;
  public Cliente(Long id, String cpf, String nome, double saldo, double deposito, double saque) {
    this.id = id;
    this.cpf = cpf;
    this.nome = nome;
    this.saldo = saldo;
    this.deposito = deposito;
    this.saque = saque;
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
  public double getDeposito() {
    return deposito;
  }
  public void setDeposito(double deposito) {
    this.deposito = deposito;
  }
  public double getSaque() {
    return saque;
  }
  public void setSaque(double saque) {
    this.saque = saque;
  }

  
}
