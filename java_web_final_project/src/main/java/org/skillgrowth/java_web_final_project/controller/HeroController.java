package org.skillgrowth.java_web_final_project.controller;

import org.skillgrowth.java_web_final_project.model.Hero;
import org.springframework.web.bind.annotation.*;
import service.HeroService;

import java.util.List;

@RestController
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService1) {
        heroService = heroService1;
    }

    //returns the findAll()method
    @RequestMapping("/api/v1/heroes")
    @GetMapping
    public List<Hero> findAll(){
        return heroService.findAll();
    }

    @RequestMapping("/api/v1/posthero")
    @PostMapping
    public void saveHero(@RequestBody Hero hero) {
        heroService.save(hero);
    }

    @RequestMapping("/api/v1/heroes/{id}")
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable int id) {
        heroService.delete(id);
    }

    @RequestMapping("/api/v1/heroes/put")
    @PutMapping
    public void putMovie(@RequestBody Hero hero) {
        heroService.put(hero);
    }
}
