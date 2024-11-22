package agh.ics.oop.model;

import java.util.*;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> grasses = new HashMap<>();
    private final int n;
    private final Random random = new Random();

    public GrassField(int n) {
        this.n = n;
        placeGrassFields(n);
    }

    private void placeGrassFields(int n) {
        int range = (int) Math.sqrt(n * 10);
        while (grasses.size() < n) {
            int x = random.nextInt(range + 1);
            int y = random.nextInt(range + 1);
            Vector2d position = new Vector2d(x, y);
            if (!grasses.containsKey(position)) {
                grasses.put(position, new Grass(position));
            }
        }
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement object = super.objectAt(position);
        if(object != null) return object;
        return grasses.get(position);
    }

    public Boundary getCurrentBounds() {
        Vector2d newLowerLeft = new Vector2d(upperRight.getX(), upperRight.getY());
        Vector2d newUpperRight = new Vector2d(lowerLeft.getX(), lowerLeft.getY());
        for (WorldElement element : getElements()) {
            Vector2d position = element.getPosition();
            newLowerLeft = newLowerLeft.lowerLeft(position);
            newUpperRight = newUpperRight.upperRight(position);
        }
        return new Boundary(newLowerLeft, newUpperRight);
    }

    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elements = super.getElements();
        elements.addAll(grasses.values());
        return elements;
    }
}
