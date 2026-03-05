package com.api.rest.service;

import org.springframework.stereotype.Service;

@Service
public class DataService {
    public String getSuma(Integer a, Integer b, String moneda) {
        return a + b + " " + moneda + " Service";
    }
}
