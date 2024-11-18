package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap {
    public RectangularMap(int width, int height) {
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width - 1, height - 1);
    }

//    @Override
//    public boolean place(Animal animal) {
//        Vector2d position = animal.getPosition();
//        if (canMoveTo(position) ) {
//            animals.put(position, animal);
//            return true;
//        }
//        return false;
//    }

//    @Override
//    public void move(Animal animal, MoveDirection direction) {
//        Vector2d oldPosition = animal.getPosition();
//        animal.move(direction, this);
//        animals.remove(oldPosition);
//        animals.put(animal.getPosition(), animal);
//    }

//    @Override
//    public boolean isOccupied(Vector2d position) {
//        return objectAt(position) != null;
//    }

//    @Override
//    public WorldElement objectAt(Vector2d position) {
//        if(animals.get(position) != null) return animals.get(position);
//        return null;
//    }

//    @Override
//    public boolean canMoveTo(Vector2d position) {
//        return position.follows(lowerLeft) &&
//                position.precedes(upperRight) &&
//                !isOccupied(position);
//    }

//    @Override
//    public String toString() {
//        return visualizer.draw(lowerLeft, upperRight);
//    }
}
