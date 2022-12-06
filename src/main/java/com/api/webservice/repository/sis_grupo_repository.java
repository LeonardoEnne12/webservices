package com.api.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.webservice.models.sis_grupo;


@Repository
public interface sis_grupo_repository extends JpaRepository<sis_grupo, Long> {
    
}