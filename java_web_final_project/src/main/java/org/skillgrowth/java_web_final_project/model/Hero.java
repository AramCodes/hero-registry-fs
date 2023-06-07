package org.skillgrowth.java_web_final_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Hero {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int rating; //1-5 stars
    private int strength;
    private String weapon;


    public Hero() {
    }

    public Hero(int id, String name, int rating, int strength, String weapon) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.strength = strength;
        this.weapon = weapon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero hero)) return false;
        return getId() == hero.getId() && getRating() == hero.getRating() && getStrength() == hero.getStrength() && Objects.equals(getName(), hero.getName()) && Objects.equals(getWeapon(), hero.getWeapon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRating(), getStrength(), getWeapon());
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
