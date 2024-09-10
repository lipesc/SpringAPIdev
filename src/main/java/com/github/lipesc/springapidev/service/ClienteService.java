package com.github.lipesc.springapidev.service;

import org.springframework.stereotype.Service;

import com.github.lipesc.springapidev.entity.Cliente;
import com.github.lipesc.springapidev.repository.ClienteRepository;

@Service
public class ClienteService {

  private ClienteRepository clienteRepository;

  public ClienteService(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  public Cliente criarCliente(Cliente cliente) {
    if (!isValidCPF(cliente.getCpf())) {
      throw new RuntimeException("CPF inválido");
    }
    return clienteRepository.save(cliente);
  }

  private boolean isValidCPF(String cpf) {
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
