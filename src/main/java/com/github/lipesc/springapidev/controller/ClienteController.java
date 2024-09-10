package com.github.lipesc.springapidev.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.lipesc.springapidev.entity.Cliente;
import com.github.lipesc.springapidev.repository.ClienteRepository;

@RestController
@RequestMapping("api/clientes")
class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;

  @GetMapping
  public List<Cliente> findAllClientes() {
    return clienteRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
    // System.out.println("Id: " + id);
    Cliente cliente = clienteRepository.cliente(id);
    return ResponseEntity.ok(cliente);
  }
}
