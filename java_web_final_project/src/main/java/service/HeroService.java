package service;

import org.skillgrowth.java_web_final_project.model.Hero;
import org.springframework.stereotype.Service;

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

    public void save(Hero hero) {
        heroRepository.save(hero);
    }

    public void put(Hero hero) {
        int id = hero.getId();
        Hero foundHero = heroRepository.getReferenceById(id);
        foundHero.setName(hero.getName());
        foundHero.setRating(hero.getRating());
        foundHero.setStrength(hero.getStrength());
        foundHero.setWeapon(hero.getWeapon());
        heroRepository.save(foundHero);
    }

    public void delete(int id) {
        heroRepository.deleteById(id);
    }
}
