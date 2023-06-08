package org.skillgrowth.java_web_final_project.service;

import org.skillgrowth.java_web_final_project.model.HeroDTO;
import org.skillgrowth.java_web_final_project.model.Hero;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class HeroService {

    private final HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    public void saveHero(HeroDTO newHero) {
        Hero heroToAdd = new Hero();

        heroToAdd.setName(newHero.name());
        heroToAdd.setRating(newHero.rating());

        heroRepository.save(heroToAdd);
    }

    public void putHero(Hero hero) {
        int id = hero.getId();
        Hero foundHero = heroRepository.findById(id).orElseThrow();
        foundHero.setName(hero.getName());
        foundHero.setRating(hero.getRating());
        foundHero.setStrength(hero.getStrength());
        foundHero.setWeapon(hero.getWeapon());
        heroRepository.save(foundHero);
    }

    public void delete(int id) {
        heroRepository.deleteById(id);
    }

    public void putHero(HeroDTO hero, int id) {
        Hero foundHero = heroRepository.findById(id).orElseThrow();
        foundHero.setName(hero.name());
        foundHero.setRating(hero.rating());
        heroRepository.save(foundHero);
    }

    public void putHero(HeroDTO hero, Integer id) {
    }
}
