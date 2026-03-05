package com.api.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.entity.Tarea;
import com.api.rest.service.TareaService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1")
@Tag(name = "Tareas", description = "Operaciones sobre MySQL Tareas")
public class TareaController {

    private TareaService tareaService;
    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }


    @GetMapping("/tareas")
    public List<Tarea> findAllTareas() {
        return tareaService.findAllTareas() ;
    }
    

    
}
