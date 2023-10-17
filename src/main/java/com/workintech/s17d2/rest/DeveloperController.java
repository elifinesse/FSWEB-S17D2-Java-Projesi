package com.workintech.s17d2.rest;

import com.workintech.s17d2.model.Developer;
import com.workintech.s17d2.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/workintech")
public class DeveloperController {

    private Map<Integer, Developer> developers;

    @PostConstruct
    public void initialize(){
        developers = new HashMap<>();
    }

    public DeveloperController(Taxable taxable){
        this.developers = new HashMap<>();
    }
    @PostMapping("/developers")
    public List<Developer> getDevelopers(){
        return developers.values().stream().toList();
    }
    @PostMapping("/developers/{id]")
    public Developer findDeveloper(int id){
        return developers.get(id);
    }


}
