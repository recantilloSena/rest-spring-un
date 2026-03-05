package com.api.rest.controller;

import com.api.rest.service.DataService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Datos", description = "Operaciones sobre datos")
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/suma/{a}/{b}")
    public String getSuma(
            @Parameter(description = "a Primer número", example = "10", required = true)
            @PathVariable Integer a,
            @Parameter(description = "b Segundo número", example = "200", required = true)
            @PathVariable Integer b,
            @Parameter(description = "Moneda (USD, COP, EUR)", example = "USD")
            @RequestParam(defaultValue = "COP") String moneda
    )
    {
        return  dataService.getSuma(a,b,moneda);
    }
}
