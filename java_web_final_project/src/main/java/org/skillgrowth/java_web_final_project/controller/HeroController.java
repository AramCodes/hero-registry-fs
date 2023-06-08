package org.skillgrowth.java_web_final_project.controller;

import org.skillgrowth.java_web_final_project.model.Hero;
import org.skillgrowth.java_web_final_project.model.HeroDTO;
import org.springframework.web.bind.annotation.*;
import org.skillgrowth.java_web_final_project.service.HeroService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/heroes")
@CrossOrigin
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService1) {
        heroService = heroService1;
    }

    //returns the findAll()method
    @GetMapping
    public List<Hero> findAll(){
        return heroService.findAll();
    }

    @PostMapping
    public void saveHero(@RequestBody HeroDTO hero) {
            heroService.saveHero(hero);
    }

    @PutMapping
    public void putHero(@RequestBody Hero hero){
        heroService.putHero(hero);
    }
    @PutMapping("/{id}")
    public void putHero(@RequestBody HeroDTO hero, @PathVariable Integer id) {
        heroService.putHero(hero, id);
    }
    @DeleteMapping("/{id}")
    public void deleteHero(@PathVariable int id) {
        heroService.delete(id);
    }


}
