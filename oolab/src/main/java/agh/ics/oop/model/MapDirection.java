package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public String toString(){

        return switch(this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case EAST  -> "Wschód";
            case WEST  -> "Zachód";
        };
    }
    public MapDirection next() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST ->  SOUTH;
            case SOUTH ->  WEST;
            case WEST -> NORTH;
        };
    }
    public MapDirection previous() {
        return switch (this) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case EAST -> NORTH;
            case WEST -> SOUTH;
        };
    }
    public Vector2d toUnitVector() {
        return switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case EAST -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
        };
    }
}
