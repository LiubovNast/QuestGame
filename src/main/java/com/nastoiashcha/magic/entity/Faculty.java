package com.nastoiashcha.magic.entity;

public class Faculty {

    private final Houses name;
    private final Color color;
    private final Animal animal;
    private final Place place;
    private final Color textColor;

    public Faculty(Houses name, Color color, Animal animal, Place place, Color textColor) {
        this.name = name;
        this.color = color;
        this.animal = animal;
        this.place = place;
        this.textColor = textColor;
    }

    public Houses getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Place getPlace() {
        return place;
    }

    public Color getTextColor() {
        return textColor;
    }
}
