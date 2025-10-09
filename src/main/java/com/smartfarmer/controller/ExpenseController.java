package com.smartfarmer.controller;

import com.smartfarmer.model.Expense;
import com.smartfarmer.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin
public class ExpenseController {
    private final ExpenseRepository repo;
    public ExpenseController(ExpenseRepository repo) { this.repo = repo; }

    @GetMapping public List<Expense> all() { return repo.findAll(); }
    @PostMapping public Expense create(@RequestBody Expense e) { return repo.save(e); }
    @DeleteMapping("{id}") public void delete(@PathVariable Long id) { repo.deleteById(id); }
}
