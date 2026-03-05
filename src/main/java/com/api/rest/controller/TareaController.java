package com.api.rest.controller;

import com.api.rest.entity.Tarea;
import com.api.rest.service.TareaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/tareas")
@Tag(name = "Tareas - Streams", description = "Ejemplos de Stream API de Java aplicados a Tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping("/")
    public List<Tarea> findAllTareas() {
        return tareaService.findAllTareas();
    }
     





    // ==========================================
    // EJEMPLO 1: FILTER + MAP + COLLECT
    // ==========================================
    @Operation(
        summary = "Filter + Map + Collect",
        description = """
                🔹 STREAM EJEMPLO 1
                Obtiene solo los TÍTULOS de las tareas NO completadas.
                Operaciones: filter() → map() → collect()
                """
    )
    @GetMapping("/stream/titulos-incompletas")
    public List<String> getTitulosTareasIncompletas() {
        return tareaService.getTitulosTareasIncompletas();
    }

    // ==========================================
    // EJEMPLO 2: SORTED + LIMIT
    // ==========================================
    @Operation(
        summary = "Sorted + Limit",
        description = """
                🔹 STREAM EJEMPLO 2
                Obtiene las 3 tareas más recientes ordenadas por fecha descendente.
                Operaciones: filter() → sorted() → limit() → collect()
                """
    )
    @GetMapping("/stream/recientes")
    public List<Tarea> getTopTareasRecientes() {
        return tareaService.getTop3TareasRecientes();
    }

    // ==========================================
    // EJEMPLO 3: GROUP BY + COUNTING
    // ==========================================
    @Operation(
        summary = "GroupingBy + Counting",
        description = """
                🔹 STREAM EJEMPLO 3
                Agrupa las tareas por estado y cuenta cuántas hay en cada grupo.
                Operaciones: collect() → groupingBy() → counting()
                Resultado: { "completadas": 5, "pendientes": 3 }
                """
    )
    @GetMapping("/stream/resumen-estado")
    public Map<String, Long> getResumenPorEstado() {
        return tareaService.getResumenPorEstado();
    }
}