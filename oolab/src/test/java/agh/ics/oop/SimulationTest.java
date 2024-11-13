package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    @Test
    public void InterpretationOfMoveDirections() {
        // Given
        String[] input = {"f", "b", "r", "l", "f", "f"};

        // When
        MoveDirection[] parsedDirections = OptionsParser.parse(input);

        // Then
        List<MoveDirection> expectedDirections = Arrays.asList(
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD
        );
        assertEquals(expectedDirections, Arrays.asList(parsedDirections));
    }
    @Test
    public void EmptyInput() {
        // Given
        String[] input = {};

        // When
        MoveDirection[] parsedDirections = OptionsParser.parse(input);

        // Then
        List<MoveDirection> expectedDirections = Arrays.asList();
        assertEquals(expectedDirections, Arrays.asList(parsedDirections));
    }
    @Test
    public void InputWithInvalidCharacters() {
        // Given
        String[] input = {"f", "x", "b", "y", "r", "z"};

        // When
        MoveDirection[] parsedDirections = OptionsParser.parse(input);

        // Then
        List<MoveDirection> expectedDirections = Arrays.asList(
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT
        );
        assertEquals(expectedDirections, Arrays.asList(parsedDirections));
    }
    @Test
    public void InputWithOnlyInvalidCharacters() {
        // Given
        String[] input = {"x", "y", "z", "!"};

        // When
        MoveDirection[] parsedDirections = OptionsParser.parse(input);

        // Then
        List<MoveDirection> expectedDirections = Arrays.asList();
        assertEquals(expectedDirections, Arrays.asList(parsedDirections));
    }
}