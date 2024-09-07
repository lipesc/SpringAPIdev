package com.github.lipesc.tgidjavadeveloper.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/empresas")
public class EmpresaController {

  @Autowired
  EmpresaRepository empresaRepository;

  @PostMapping
  public Empresa create(@RequestBody Empresa empresa) {
    return empresaRepository.save(empresa);
  }

  @GetMapping
  public Page<Empresa> list(Pageable pageable) {
    return empresaRepository.findAll(pageable);
  }

  @GetMapping("/cnpj")
  public Page<Empresa> listByCnpj(String cnpj, Pageable pageable) {
    return empresaRepository.findByCnpj(cnpj, pageable);
  }
}
