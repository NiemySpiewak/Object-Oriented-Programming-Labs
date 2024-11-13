package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    void isOrientationCorrect() {
        //Given
        Animal animal = new Animal(new Vector2d(2, 2));
        RectangularMap validator = new RectangularMap(10, 10);

        //Then
        assertEquals("N", animal.toString());

        //When
        animal.move(MoveDirection.FORWARD, validator);
        //Then
        assertEquals("N", animal.toString());

        //When
        animal.move(MoveDirection.BACKWARD, validator);
        //Then
        assertEquals("N", animal.toString());

        //When
        animal.move(MoveDirection.RIGHT, validator);
        //Then
        assertEquals("E", animal.toString());

        //When
        animal.move(MoveDirection.LEFT, validator);
        //Then
        assertEquals("N", animal.toString());
    }

    @Test
    public void doesntGoOutsideBounds() {
        // Given
        Animal animal = new Animal(new Vector2d(2, 2));
        RectangularMap validator = new RectangularMap(10, 10);

        // When
        animal.move(MoveDirection.BACKWARD, validator);
        animal.move(MoveDirection.BACKWARD, validator);
        animal.move(MoveDirection.BACKWARD, validator);

        // Then
        assertEquals("N", animal.toString());

        //When
        animal.move(MoveDirection.FORWARD, validator);
        animal.move(MoveDirection.LEFT, validator);
        animal.move(MoveDirection.FORWARD, validator);
        animal.move(MoveDirection.FORWARD, validator);
        animal.move(MoveDirection.FORWARD, validator);
        //Then
        assertEquals("W", animal.toString());

        //When
        animal.move(MoveDirection.LEFT, validator);
        animal.move(MoveDirection.FORWARD, validator);
        animal.move(MoveDirection.FORWARD, validator);
        //Then
        assertEquals("S", animal.toString());

        //When
        animal.move(MoveDirection.RIGHT, validator);
        animal.move(MoveDirection.RIGHT, validator);
        animal.move(MoveDirection.FORWARD, validator);
        animal.move(MoveDirection.FORWARD, validator);
        animal.move(MoveDirection.FORWARD, validator);
        animal.move(MoveDirection.FORWARD, validator);
        animal.move(MoveDirection.FORWARD, validator);
        //Then
        assertEquals("N", animal.toString());

        //When
        animal.move(MoveDirection.RIGHT, validator);
        animal.move(MoveDirection.FORWARD, validator);
        animal.move(MoveDirection.FORWARD, validator);
        animal.move(MoveDirection.FORWARD, validator);
        animal.move(MoveDirection.FORWARD, validator);
        animal.move(MoveDirection.FORWARD, validator);
        //Then
        assertEquals("E", animal.toString());
    }
}