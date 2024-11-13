package agh.ics.oop.model;
public class Animal {
    private Vector2d position;
    private MapDirection orientation;

    public Animal() {
        this.position = new Vector2d(2,2);
        this.orientation = MapDirection.NORTH;
    }
    public Animal(Vector2d position) {
        this.position = position;
        this.orientation = MapDirection.NORTH;
    }

    @Override
    public String toString() {
        return switch (this.orientation) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case WEST -> "W";
            case EAST -> "E";
        };
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public Vector2d getPosition() {
        return this.position;
    }
    private static final Vector2d LOWER_BOUND = new Vector2d(0,0);
    private static final Vector2d UPPER_BOUND = new Vector2d(4,4);

    public void move(MoveDirection direction, MoveValidator map){
        switch(direction){
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case FORWARD:
                Vector2d newPosition = this.position.add(this.orientation.toUnitVector());
                if (map.canMoveTo(newPosition)) {
                    this.position = newPosition;
                }
                break;
            case BACKWARD:
                Vector2d newPositionBack = this.position.subtract(this.orientation.toUnitVector());
                if (map.canMoveTo(newPositionBack)) {
                    this.position = newPositionBack;
                }
                break;
            default:
                break;
        }
    }
}
