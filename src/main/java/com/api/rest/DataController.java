package com.api.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Datos", description = "Operaciones sobre datos")
public class DataController {


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
        return  a + b + " - " + moneda;
    }
}
