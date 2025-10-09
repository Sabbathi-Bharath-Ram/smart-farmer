package com.smartfarmer.controller;

import com.smartfarmer.model.Harvest;
import com.smartfarmer.repository.HarvestRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/harvests")
@CrossOrigin
public class HarvestController {
    private final HarvestRepository repo;
    public HarvestController(HarvestRepository repo) { this.repo = repo; }

    @GetMapping public List<Harvest> all() { return repo.findAll(); }
    @PostMapping public Harvest create(@RequestBody Harvest h) { return repo.save(h); }
    @DeleteMapping("{id}") public void delete(@PathVariable Long id) { repo.deleteById(id); }
}
