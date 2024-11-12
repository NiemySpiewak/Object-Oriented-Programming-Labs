package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    List<Animal> animals = new ArrayList<>();
    List<MoveDirection> directions;
    private final MoveValidator validator;

    public Simulation(List<Vector2d> InitialPosition,List<MoveDirection> directions, MoveValidator validator) {
        this.directions = directions;
        this.validator = validator;
        for(Vector2d position : InitialPosition) {
            animals.add(new Animal(position));
        }
    }
    public void run(){
        for(int i=0; i < directions.size(); i++){
            Animal animal = animals.get(i % animals.size());
            MoveDirection InitialPosition = directions.get(i);

            animal.move(InitialPosition, validator);
            System.out.println("Zwierze " + (i % animals.size()) + ": " + animal);
        }
    }
}
