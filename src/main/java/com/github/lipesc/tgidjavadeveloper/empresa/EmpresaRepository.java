package com.github.lipesc.tgidjavadeveloper.empresa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
  Page<Empresa> findByCnpj(String cnpj, Pageable pageable); 

}
