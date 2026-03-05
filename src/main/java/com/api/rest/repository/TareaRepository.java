package com.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rest.entity.Tarea;

public interface TareaRepository extends JpaRepository<Tarea,Integer> {
    
}
