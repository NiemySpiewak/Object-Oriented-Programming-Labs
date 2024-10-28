package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {
    @Test
    void NextDirectionInClockwiseOrder(){
        // Given
        MapDirection north = MapDirection.NORTH;
        MapDirection east = MapDirection.EAST;
        MapDirection south = MapDirection.SOUTH;
        MapDirection west = MapDirection.WEST;

        // When
        MapDirection northNext = north.next();
        MapDirection eastNext = east.next();
        MapDirection southNext = south.next();
        MapDirection westNext = west.next();

        // Then
        assertEquals(MapDirection.EAST, northNext);
        assertEquals(MapDirection.SOUTH, eastNext);
        assertEquals(MapDirection.WEST, southNext);
        assertEquals(MapDirection.NORTH, westNext);
    }

    @Test
    void PreviousDirectionInCounterclockwiseOrder(){
        // Given
        MapDirection north = MapDirection.NORTH;
        MapDirection east = MapDirection.EAST;
        MapDirection south = MapDirection.SOUTH;
        MapDirection west = MapDirection.WEST;

        // When
        MapDirection northPrevious = north.previous();
        MapDirection westPrevious = west.previous();
        MapDirection southPrevious = south.previous();
        MapDirection eastPrevious = east.previous();

        // Then
        assertEquals(MapDirection.WEST, northPrevious);
        assertEquals(MapDirection.SOUTH, westPrevious);
        assertEquals(MapDirection.EAST, southPrevious);
        assertEquals(MapDirection.NORTH, eastPrevious);
    }
}