package com.workintech.s17d2.rest;

import com.workintech.s17d2.model.Developer;
import com.workintech.s17d2.model.DeveloperFactory;
import com.workintech.s17d2.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/developers")
public class DeveloperController {

    private Map<Integer, Developer> developers;
    private Taxable taxable;

    @PostConstruct
    public void initialize(){
        developers = new HashMap<>();
    }
    @Autowired
    public DeveloperController(Taxable taxable){
        this.taxable = taxable;
    }
    @GetMapping("/")
    public List<Developer> getDevelopers(){
        return developers.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Developer findDeveloper(@PathVariable int id){
        return developers.get(id);
    }
    @PostMapping("/")
    public Developer createDeveloper(@RequestBody Developer developer){
        Developer created = DeveloperFactory.createDev(developer, taxable);
        developers.put(developer.getId(), created);
        return created;
    }
    @PutMapping("/{id}")
    public Developer updateDeveloper(@PathVariable int id, @RequestBody Developer developer){
        Developer updated = DeveloperFactory.createDev(developer, taxable);
        developers.put(id, updated);
        return updated;
    }

    @DeleteMapping("/{id}")
    public Developer deleteDeveloper(@PathVariable int id){
        return developers.remove(id);
    }

}
