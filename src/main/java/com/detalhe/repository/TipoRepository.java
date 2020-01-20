package com.detalhe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.detalhe.model.Tipo;;

public interface TipoRepository extends JpaRepository<Tipo, Long> {

}
