package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    void CorrectLetters(){
        // Given
        String[] letters = {"f", "b", "r", "l"};

        // When
        MoveDirection[] result = OptionsParser.parse(letters);

        // Then
        assertEquals(MoveDirection.FORWARD, result[0]);
        assertEquals(MoveDirection.BACKWARD, result[1]);
        assertEquals(MoveDirection.RIGHT, result[2]);
        assertEquals(MoveDirection.LEFT, result[3]);
    }

    @Test
    void wrongLetters(){
        // Given
        String[] letters = {"f", "b", "r", "blad", "l"};

        // When
        MoveDirection[] result = OptionsParser.parse(letters);

        // Then
        assertEquals(MoveDirection.FORWARD, result[0]);
        assertEquals(MoveDirection.BACKWARD, result[1]);
        assertEquals(MoveDirection.RIGHT, result[2]);
        assertEquals(MoveDirection.LEFT, result[3]);
    }

}