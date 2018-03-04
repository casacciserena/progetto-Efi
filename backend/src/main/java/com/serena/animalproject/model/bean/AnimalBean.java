package com.serena.animalproject.model.bean;

import java.io.Serializable;

public class AnimalBean implements Serializable {

    private long animal_id;
    private String animal_name;
    private String animal_family;
    private String animal_race;
    private String animal_descent;
    private int animal_legs;

    public AnimalBean() {

    }

    /**
     * @return the animal_id
     */
    public long getAnimal_id() {
        return animal_id;
    }

    /**
     * @param animal_id the animal_id to set
     */
    public void setAnimal_id(long animal_id) {
        this.animal_id = animal_id;
    }

    /**
     * @return the animal_name
     */
    public String getAnimal_name() {
        return animal_name;
    }

    /**
     * @param animal_name the animal_name to set
     */
    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    /**
     * @return the animal_family
     */
    public String getAnimal_family() {
        return animal_family;
    }

    /**
     * @param animal_family the animal_family to set
     */
    public void setAnimal_family(String animal_family) {
        this.animal_family = animal_family;
    }

    /**
     * @return the animal_race
     */
    public String getAnimal_race() {
        return animal_race;
    }

    /**
     * @param animal_race the animal_race to set
     */
    public void setAnimal_race(String animal_race) {
        this.animal_race = animal_race;
    }

    /**
     * @return the animal_descent
     */
    public String getAnimal_descent() {
        return animal_descent;
    }

    /**
     * @param animal_descent the animal_descent to set
     */
    public void setAnimal_descent(String animal_descent) {
        this.animal_descent = animal_descent;
    }

    /**
     * @return the animal_legs
     */
    public int getAnimal_legs() {
        return animal_legs;
    }

    /**
     * @param animal_legs the animal_legs to set
     */
    public void setAnimal_legs(int animal_legs) {
        this.animal_legs = animal_legs;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName())
                .append(" [animal_id=").append(animal_id)
                .append(", animal_name=").append(animal_name)
                .append(", animal_family=").append(animal_family)
                .append(", animal_race=").append(animal_race)
                .append(", animal_descent=").append(animal_descent)
                .append(", animal_legs=").append(animal_legs)
                .append("]");
        return builder.toString();
    }
}