package org.skillgrowth.java_web_final_project.service;

import org.skillgrowth.java_web_final_project.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer> {

}
