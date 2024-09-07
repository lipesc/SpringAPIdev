package com.github.lipesc.tgidjavadeveloper.empresa;

import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

  private final EmpresaRepository empresaRepository;

  public EmpresaService(EmpresaRepository empresaRepository) {
    this.empresaRepository = empresaRepository;
  }


  public void criar(Empresa empresa) {
    empresaRepository.save(empresa);
  }

  public void nome(Empresa empresa, String nome) {
    empresa.setNome(nome);
  }

  public void saldo(Empresa empresa, double saldo) {
    empresa.setSaldo(saldo);
  }

  public void receberDeposito(Empresa empresa, double receberDeposito) {
    empresa.setDeposito(receberDeposito);
  }

  public void taxaSaque(Empresa empresa, double taxaSaque) {
    empresa.setTaxaSaque(taxaSaque);
  }

  public void cnpj(Empresa empresa, String cnpj) {
    empresa.setCnpj(cnpj);
  }

  public void deletar(Empresa empresa) {
    empresaRepository.delete(empresa);
  }

  public void buscar(Empresa empresa) {
    empresaRepository.findById(empresa.getId());
  }

  public void buscarTodos() {
    empresaRepository.findAll();
  }
}
