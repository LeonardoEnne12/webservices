package com.api.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.webservice.models.sis_usuario;


@Repository
public interface sis_usuario_repository extends JpaRepository<sis_usuario, Long> {
    
}
