package com.github.lipesc.springapidev.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.lipesc.springapidev.entity.Empresa;
import com.github.lipesc.springapidev.repository.EmpresaRepository;

@Controller
@RequestMapping("api/empresas")
public class EmpresaController {

  @Autowired
  private EmpresaRepository empresaRepository;

  @GetMapping
  public List<Empresa> findAllClientes() {
    return empresaRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Empresa> getClienteById(@PathVariable Long id) {
    Empresa empresa = empresaRepository.empresa(id);
    return ResponseEntity.ok(empresa);
  }
}
