package com.career.platform.controller;

import com.career.platform.entity.CareerResource;
import com.career.platform.service.CareerResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/career-resources")
@CrossOrigin(origins = "http://localhost:5173") // Connect with Vite Frontend
public class CareerResourceController {

    @Autowired
    private CareerResourceService service;

    @GetMapping
    public List<CareerResource> getAllResources() {
        return service.getAllResources();
    }

    @PostMapping
    public CareerResource addResource(@RequestBody CareerResource resource) {
        return service.addResource(resource);
    }
}
