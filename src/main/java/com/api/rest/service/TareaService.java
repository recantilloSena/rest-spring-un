package com.api.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.rest.entity.Tarea;
import com.api.rest.repository.TareaRepository;

@Service
public class TareaService {
    
private  TareaRepository tareaRepository;

public TareaService(TareaRepository tareaRepository) {
    this.tareaRepository = tareaRepository;
}

public List<Tarea> findAllTareas(){
    return tareaRepository.findAll();
}


}
