package com.api.rest.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.api.rest.entity.Tarea;
import com.api.rest.repository.TareaRepository;

@Service
public class TareaService {

private final GeminiService geminiService;    
private  TareaRepository tareaRepository;

public TareaService(TareaRepository tareaRepository, GeminiService geminiService) {
    this.tareaRepository = tareaRepository;
    this.geminiService = geminiService;
}

/*
Uso Básico del Service y el Repository de JPA y  SpringData
*/
public List<Tarea> findAllTareas(){
    return tareaRepository.findAll();
}


// ==========================================
// 1. FILTER + MAP + COLLECT
// Obtener solo los títulos de las tareas NO completadas
// ==========================================
public List<String> getTitulosTareasIncompletas() {
    return tareaRepository.findAll()
            .stream()
            .filter(tarea -> !tarea.getCompletado())        // filtra las no completadas
            .map(Tarea::getTitulo)                          // extrae solo el título
            .collect(Collectors.toList());                  // convierte el stream a List
}

// ==========================================
// 2. SORTED + LIMIT
// Obtener las 3 tareas más recientes ordenadas por fecha descendente
// ==========================================
public List<Tarea> getTop3TareasRecientes() {
    return tareaRepository.findAll()
            .stream()
            .filter(tarea -> tarea.getFecha() != null)      // evita nulls
            .sorted(Comparator.comparing(Tarea::getFecha).reversed()) // ordena desc por fecha
            .limit(3)                                       // toma solo las primeras 3
            .collect(Collectors.toList());
}

// ==========================================
// 3. GROUP BY + COUNTING
// Agrupar tareas por estado (completadas vs pendientes) y contar cada grupo
// ==========================================
public Map<String, Long> getResumenPorEstado() {
    return tareaRepository.findAll()
            .stream()
            .collect(Collectors.groupingBy(
                    tarea -> tarea.getCompletado() ? "completadas" : "pendientes", // clave del grupo
                    Collectors.counting()                                           // cuenta cada grupo
            ));
    
}

String getTips(String iaTips) {
    return geminiService.generarRespuesta("Dame una recomendación para estudiar el tema "+iaTips) ;                  // convierte el stream a List
}

public String getTipsTarea(Integer id){    
    Tarea tarea = tareaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarea no encontrada con id: " + id));    
    return getTips(tarea.getTitulo());
}


}
