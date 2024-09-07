package com.github.lipesc.tgidjavadeveloper.cliente;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {

  private final ClienteRepository clienteRepository;

  public ClienteService(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  public void criar(Cliente cliente) {
    clienteRepository.save(cliente);
  }

  public void nome(Cliente cliente, String nome) {
    cliente.setNome(nome);
  }

  public void cpf(Cliente cliente, String cpf) {
    cliente.setCpf(cpf);
  }

  public void saldo(Cliente cliente, double saldo) {
    cliente.setSaldo(saldo);
  }

  public void deposito(Cliente cliente, double deposito) {
    cliente.setDeposito(deposito);
  }

  public void saque(Cliente cliente, double saque) {
    cliente.setSaque(saque);
  }

  public void deletar(Cliente cliente) {
    clienteRepository.delete(cliente);
  }

  public void atualizar(Cliente cliente) {
    clienteRepository.save(cliente);
  }

  public void buscar(Cliente cliente) {
    clienteRepository.findById(cliente.getId());
  }

  public void buscarTodos() {
    clienteRepository.findAll();
  }
}
