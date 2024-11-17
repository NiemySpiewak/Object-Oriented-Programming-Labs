package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    List<Animal> animals = new ArrayList<>();
    List<MoveDirection> directions;
    private final WorldMap map;

    public Simulation(List<Vector2d> InitialPosition,List<MoveDirection> directions, WorldMap map) {
        this.directions = directions;
        this.map = map;
        this.animals = new ArrayList<>();
        for(Vector2d position : InitialPosition) {
            Animal Animal = new Animal(position);
            if(map.place(new Animal())){
                this.animals.add(new Animal());
            }
        }
        if(map.place(new Animal())){
            this.animals.add(new Animal());
        }
    }
    public void run(){
        System.out.println(map);
        for(int i=0; i < directions.size(); i++){
            Animal animal = animals.get(i % animals.size());
            MoveDirection InitialPosition = directions.get(i);

            map.move(animal, InitialPosition);
            System.out.println(map);
        }
    }
}
