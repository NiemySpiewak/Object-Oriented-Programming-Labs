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


        //Then
        assertEquals("[position=(2,2), orientation=Północ]", animal.toString());

        //When
        animal.move(MoveDirection.FORWARD);
        //Then
        assertEquals("[position=(2,3), orientation=Północ]", animal.toString());

        //When
        animal.move(MoveDirection.BACKWARD);
        //Then
        assertEquals("[position=(2,2), orientation=Północ]", animal.toString());

        //When
        animal.move(MoveDirection.RIGHT);
        //Then
        assertEquals("[position=(2,2), orientation=Wschód]", animal.toString());

        //When
        animal.move(MoveDirection.LEFT);
        //Then
        assertEquals("[position=(2,2), orientation=Północ]", animal.toString());
    }

    @Test
    public void doesntGoOutsideBounds() {
        // Given
        Animal animal = new Animal(new Vector2d(2, 2));

        // When
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);

        // Then
        assertEquals("[position=(2,0), orientation=Północ]", animal.toString());

        //When
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        //Then
        assertEquals("[position=(0,1), orientation=Zachód]", animal.toString());

        //When
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        //Then
        assertEquals("[position=(0,0), orientation=Południe]", animal.toString());

        //When
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        //Then
        assertEquals("[position=(0,4), orientation=Północ]", animal.toString());

        //When
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        //Then
        assertEquals("[position=(4,4), orientation=Wschód]", animal.toString());
    }
}