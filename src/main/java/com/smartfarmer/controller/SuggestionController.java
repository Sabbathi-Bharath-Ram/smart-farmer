package com.smartfarmer.controller;

import com.smartfarmer.model.Field;
import com.smartfarmer.repository.FieldRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/suggest")
@CrossOrigin
public class SuggestionController {
    private final FieldRepository fieldRepo;
    public SuggestionController(FieldRepository fieldRepo) { this.fieldRepo = fieldRepo; }

    @GetMapping("/byField/{fieldId}")
    public List<String> suggestByField(@PathVariable Long fieldId){
        Optional<Field> of = fieldRepo.findById(fieldId);
        List<String> res = new ArrayList<>();
        if(of.isEmpty()) return res;
        Field f = of.get();
        String soil = (f.getSoilType()==null) ? "" : f.getSoilType().toLowerCase();
        double area = (f.getArea()==null) ? 0.0 : f.getArea();

        if(soil.contains("loam") || soil.contains("loamy")){
            res.add("Wheat"); res.add("Maize");
            if(area >= 1.0) res.add("Sunflower");
        } else if(soil.contains("sandy")){
            res.add("Groundnut"); if(area >= 0.5) res.add("Millets");
        } else if(soil.contains("clay")){
            res.add("Paddy (Rice)"); if(area >= 2.0) res.add("Sugarcane");
        } else {
            if(area <= 0.5) res.add("Vegetables (Tomato, Brinjal)");
            else if(area <= 2.0){ res.add("Maize"); res.add("Wheat"); }
            else { res.add("Wheat"); res.add("Paddy (Rice)"); res.add("Sugarcane"); }
        }
        return res;
    }
}
