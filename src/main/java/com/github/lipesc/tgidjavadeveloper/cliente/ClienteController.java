package com.github.lipesc.tgidjavadeveloper.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/clientes")
public class ClienteController {

  @Autowired
  ClienteRepository clienteRepository;

  @PostMapping
  public Cliente create(@RequestBody Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  @GetMapping
  public Page<Cliente> list(Pageable pageable) {
    return clienteRepository.findAll(pageable);
  }

  @GetMapping("/cpf")
  public Page<Cliente> listByCpf(String cpf, Pageable pageable) {
    return clienteRepository.findByCpf(cpf, pageable);
  }
}
