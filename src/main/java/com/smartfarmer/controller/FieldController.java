package com.smartfarmer.controller;

import com.smartfarmer.model.Field;
import com.smartfarmer.repository.FieldRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fields")
@CrossOrigin
public class FieldController {
    private final FieldRepository repo;
    public FieldController(FieldRepository repo) { this.repo = repo; }

    @GetMapping public List<Field> all() { return repo.findAll(); }
    @PostMapping public Field create(@RequestBody Field f) { return repo.save(f); }
    @GetMapping("{id}") public Field get(@PathVariable Long id) { return repo.findById(id).orElse(null); }
    @DeleteMapping("{id}") public void delete(@PathVariable Long id) { repo.deleteById(id); }
}
