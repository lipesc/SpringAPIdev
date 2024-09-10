package com.github.lipesc.springapidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.lipesc.springapidev.entity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
  @Query("SELECT c FROM Empresa c WHERE c.id = :id")
  Empresa empresa(@Param("id") Long id);
}
