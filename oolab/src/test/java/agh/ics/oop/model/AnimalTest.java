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
        assertEquals("[position=(2,2), orientation=Polnoc]", animal.toString());

        //When
        animal.move(MoveDirection.FORWARD);
        //Then
        assertEquals("[position=(2,3), orientation=Polnoc]", animal.toString());

        //When
        animal.move(MoveDirection.BACKWARD);
        //Then
        assertEquals("[position=(2,2), orientation=Polnoc]", animal.toString());

        //When
        animal.move(MoveDirection.RIGHT);
        //Then
        assertEquals("[position=(2,2), orientation=Wschod]", animal.toString());

        //When
        animal.move(MoveDirection.LEFT);
        //Then
        assertEquals("[position=(2,2), orientation=Polnoc]", animal.toString());
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
        assertEquals("[position=(2,0), orientation=Polnoc]", animal.toString());

        //When
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        //Then
        assertEquals("[position=(0,1), orientation=Zachod]", animal.toString());

        //When
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        //Then
        assertEquals("[position=(0,0), orientation=Poludnie]", animal.toString());

        //When
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        //Then
        assertEquals("[position=(0,4), orientation=Polnoc]", animal.toString());

        //When
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        //Then
        assertEquals("[position=(4,4), orientation=Wschod]", animal.toString());
    }

    @Test
    public void InputParsing() {
        String[] args = {"f", "r", "f", "l", "b"};
        List<MoveDirection> directions = OptionsParser.parse(args);

        assertEquals(List.of(MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD), directions);
    }

}