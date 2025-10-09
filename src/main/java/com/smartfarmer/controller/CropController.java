package com.smartfarmer.controller;

import com.smartfarmer.model.Crop;
import com.smartfarmer.repository.CropRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
@CrossOrigin
public class CropController {

    private final CropRepository repo;

    public CropController(CropRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Crop> getAllCrops() {
        return repo.findAll();
    }

    @PostMapping
    public Crop addCrop(@RequestBody Crop crop) {
        return repo.save(crop);
    }

    @DeleteMapping("/{id}")
    public void deleteCrop(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
