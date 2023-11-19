package com.nastoiashcha.magic.service.impl;

import com.nastoiashcha.magic.entity.*;
import com.nastoiashcha.magic.service.FacultyService;

import java.util.ArrayList;
import java.util.List;

public class FacultyServiceImpl implements FacultyService {
    private final List<Faculty> faculties = createList();

    @Override
    public Faculty getByName(Houses name) {
        for (Faculty house : faculties) {
            if (house.getName() == name) {
                return house;
            }
        }
        return null;
    }

    private static List<Faculty> createList() {
        List<Faculty> list = new ArrayList<>();
        Faculty gryffindor = new Faculty(Houses.GRYFFINDOR, Color.DARKRED, Animal.LION, Place.TOWER, Color.GOLD);
        Faculty hufflepuff = new Faculty(Houses.HUFFLEPUFF, Color.YELLOW, Animal.BADGER, Place.BASEMENT, Color.BLACK);
        Faculty ravenclaw = new Faculty(Houses.RAVENCLAW, Color.LIGHTSKYBLUE, Animal.EAGLE, Place.TOWER, Color.SADDLEBROWN);
        Faculty slytherin = new Faculty(Houses.SLYTHERIN, Color.GREEN, Animal.SNAKE, Place.DUNGEON, Color.SILVER);
        list.add(gryffindor);
        list.add(hufflepuff);
        list.add(ravenclaw);
        list.add(slytherin);
        return list;
    }
}
