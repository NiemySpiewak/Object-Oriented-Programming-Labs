package agh.ics.oop.model;

import agh.ics.oop.model.util.Boundary;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected Vector2d lowerLeft = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    protected Vector2d upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected final MapVisualizer visualizer = new MapVisualizer(this);

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }
    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (canMoveTo(position) ) {
            animals.put(position, animal);
            return true;
        }
        return false;
    }


    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);
        animals.remove(oldPosition);
        animals.put(animal.getPosition(), animal);
    }

    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elements = new ArrayList<>(animals.values());
        return elements;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString() {
        return visualizer.draw(lowerLeft, upperRight);
    }

    @Override
    public Boundary getBoundary() {
        return new Boundary(lowerLeft, upperRight);
    }
}
