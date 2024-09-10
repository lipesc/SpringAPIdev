package com.github.lipesc.springapidev.service;

import org.springframework.stereotype.Service;

import com.github.lipesc.springapidev.entity.Empresa;
import com.github.lipesc.springapidev.repository.EmpresaRepository;

@Service
public class EmpresaService {

  private EmpresaRepository empresaRepository;

  public EmpresaService(EmpresaRepository empresaRepository) {
    this.empresaRepository = empresaRepository;
  }

  public Empresa criarEmpresa(Empresa empresa) {
    if (!isValidCNPJ(empresa.getCnpj())) {
      throw new RuntimeException("CNPJ inválido");
    }
    return empresaRepository.save(empresa);
  }

  private boolean isValidCNPJ(String cnpj) {
    if (cnpj == null || cnpj.length() != 11) {
      return false;
    }
    for (char c : cnpj.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }
}
