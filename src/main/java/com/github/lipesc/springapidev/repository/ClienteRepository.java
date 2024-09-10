package com.github.lipesc.springapidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.lipesc.springapidev.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
  @Query("SELECT c FROM Cliente c WHERE c.id = :id")
  Cliente cliente(@Param("id") Long id);
}
