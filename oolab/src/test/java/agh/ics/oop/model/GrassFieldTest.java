package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    @Test
    public void mapWorks() {
        // given
        WorldMap map = new GrassField(10);
        Animal animal = new Animal();

        // when
        boolean placed = map.place(animal);
        map.move(animal, MoveDirection.FORWARD);

        // then
        assertTrue(placed);
        assertEquals(new Vector2d(2, 3), animal.getPosition());
    }

    @Test
    public void canMoveTo1() {
        // given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();

        // when
        boolean placed = map.place(animal1);
        boolean canMoveToEmpty = map.canMoveTo(new Vector2d(2, 3));
        boolean canMoveToOccupied = map.canMoveTo(new Vector2d(2, 2));

        // then
        assertTrue(placed);
        assertTrue(canMoveToEmpty);
        assertFalse(canMoveToOccupied);
    }

    @Test
    public void canMoveTo2() {
        // given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(2, 3));

        // when
        boolean placed1 = map.place(animal1);
        boolean placed2 = map.place(animal2);
        boolean canMoveToOccupied = map.canMoveTo(new Vector2d(2, 3));

        // then
        assertTrue(placed1);
        assertTrue(placed2);
        assertFalse(canMoveToOccupied);
    }

    @Test
    public void placeAnimal() {
        // given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();

        // when
        boolean placed = map.place(animal1);

        // then
        assertTrue(placed);
    }

    @Test
    public void moveAnimals() {
        // given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(3, 2));

        // when
        map.place(animal1);
        map.place(animal2);
        map.move(animal1, MoveDirection.FORWARD);
        map.move(animal2, MoveDirection.LEFT);
        map.move(animal2, MoveDirection.LEFT);
        map.move(animal2, MoveDirection.FORWARD);

        // then
        assertEquals(new Vector2d(2, 3), animal1.getPosition());
        assertEquals(new Vector2d(3, 1), animal2.getPosition());
    }

    @Test
    public void isOccupied() {
        // given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();

        // when
        map.place(animal1);
        boolean occupied = map.isOccupied(new Vector2d(2, 2));

        // then
        assertTrue(occupied);
    }

    @Test
    public void isOccupiedPass() {
        // given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(2, 3));

        // when
        map.place(animal1);
        map.place(animal2);
        boolean notOccupied = map.isOccupied(new Vector2d(2, 4));

        // then
        assertFalse(notOccupied);
    }

    @Test
    public void objectAt() {
        // given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();

        // when
        map.place(animal1);
        Object object = map.objectAt(new Vector2d(2, 2));

        // then
        assertEquals(animal1, object);
    }

    @Test
    public void getElements() {
        // given
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(2, 3));

        // when
        map.place(animal1);
        map.place(animal2);
        int elementsCount = map.getElements().size();

        // then
        assertEquals(12, elementsCount);
    }


}