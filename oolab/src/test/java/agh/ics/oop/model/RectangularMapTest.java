package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    public void testMap() {
        // Given
        WorldMap map = new RectangularMap(10, 5);
        Animal animal = new Animal();

        // When
        boolean placedSuccessfully = map.place(animal);
        map.move(animal, MoveDirection.FORWARD);

        // Then
        assertTrue(placedSuccessfully);
        assertEquals(new Vector2d(2, 3), animal.getPosition());
    }

    @Test
    public void testCanMoveTo1() {
        // Given
        WorldMap map = new RectangularMap(10, 5);
        Animal animal = new Animal();

        // When
        boolean placedSuccessfully = map.place(animal);

        // Then
        assertTrue(placedSuccessfully);
        assertTrue(map.canMoveTo(new Vector2d(2, 3)));
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
    }

    @Test
    public void testCanMoveTo2() {
        // Given
        WorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(2, 1));

        // When
        boolean placed1 = map.place(animal1);
        boolean placed2 = map.place(animal2);
        map.move(animal2, MoveDirection.FORWARD);

        // Then
        assertTrue(placed1);
        assertTrue(placed2);
        assertEquals(new Vector2d(2, 1), animal2.getPosition());
    }

    @Test
    public void testPlace() {
        // Given
        WorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(2, 2));

        // When

        boolean placed1 = map.place(animal1);
        boolean placed2 = map.place(animal2);

        // Then
        assertTrue(placed1);
        assertFalse(placed2);  // animal2 nie można umieścić na tej samej pozycji
    }

    @Test
    public void testMove() {
        // Given
        WorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(3, 2));

        // When
        map.place(animal1);
        map.place(animal2);
        map.move(animal1, MoveDirection.FORWARD);
        map.move(animal2, MoveDirection.FORWARD);

        // Then
        assertEquals(new Vector2d(2, 3), animal1.getPosition());
        assertEquals(new Vector2d(3, 3), animal2.getPosition());
    }

    @Test
    public void testIsOccupied() {
        // Given
        WorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(2, 2));

        // When
        map.place(animal1);
        boolean placed2 = map.place(animal2);

        // Then
        assertFalse(placed2);  // animal2 nie może być umieszczony, ponieważ pozycja jest już zajęta
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertFalse(map.isOccupied(new Vector2d(2, 3)));
    }

    @Test
    public void testObjectAt() {
        // Given
        WorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(2, 3));

        // When
        map.place(animal1);
        map.place(animal2);

        // Then
        assertEquals(animal1, map.objectAt(new Vector2d(2, 2)));
        assertEquals(animal2, map.objectAt(new Vector2d(2, 3)));
    }

}