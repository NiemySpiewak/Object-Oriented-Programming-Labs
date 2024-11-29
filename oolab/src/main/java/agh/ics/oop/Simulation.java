package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.IncorrectPositionException;

import java.util.ArrayList;
import java.util.List;

public class Simulation implements Runnable {
    List<Animal> animals = new ArrayList<>();
    List<MoveDirection> directions;
    private final WorldMap map;

    public Simulation(List<Vector2d> InitialPosition,List<MoveDirection> directions, WorldMap map)
    {
        this.directions = directions;
        this.map = map;
        this.animals = new ArrayList<>();

        for(Vector2d position : InitialPosition) {
            Animal animal = new Animal(position);
            try
            {
                map.place(animal);
                this.animals.add(animal);
            }
            catch (IncorrectPositionException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    public List<Animal> getAnimals() {
        return this.animals ;
    }
    public void run(){
        //System.out.println(map);
        for(int i=0; i < directions.size(); i++){
            Animal animal = animals.get(i % animals.size());
            MoveDirection InitialPosition = directions.get(i);

            map.move(animal, InitialPosition);
            System.out.println(map);
        }
    }
}
