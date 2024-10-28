package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    @Test
    void VectorEquality(){
        // Given
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(1, 2);
        Vector2d vector3 = new Vector2d(2, 3);

        // When
        boolean isEqualToVector2 = vector1.equals(vector2);
        boolean isEqualToVector3 = vector1.equals(vector3);

        // Then
        assertTrue(isEqualToVector2);
        assertFalse(isEqualToVector3);
    }

    @Test
    void VectorToString(){
        // Given
        Vector2d vector = new Vector2d(1, 2);

        // When
        String vectorString = vector.toString();

        // Then
        assertEquals("(1,2)", vectorString);
    }

    @Test
    void VectorIsLessThanOrEqual(){
        // Given
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(2, 3);
        Vector2d vector3 = new Vector2d(1, 1);

        // When
        boolean result1 = vector1.precedes(vector2);
        boolean result2 = vector1.precedes(vector3);

        // Then
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    void VectorIsGreaterThanOrEqual(){
        // Given
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(1, 2);
        Vector2d vector3 = new Vector2d(3, 4);

        // When
        boolean result1 = vector1.follows(vector2);
        boolean result2 = vector1.follows(vector3);

        // Then
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    void VectorReturnsUpperRightCorner(){
        // Given
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(2, 1);

        // When
        Vector2d result = vector1.upperRight(vector2);

        // Then
        assertEquals(new Vector2d(2, 2), result);
    }

    @Test
    void VectorReturnsLowerLeftCorner(){
        // Given
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(2, 1);

        // When
        Vector2d result = vector1.lowerLeft(vector2);

        // Then
        assertEquals(new Vector2d(1, 1), result);
    }

    @Test
    void VectorAddition(){
        // Given
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(2, 3);

        // When
        Vector2d result = vector1.add(vector2);

        // Then
        assertEquals(new Vector2d(3, 5), result);
    }

    @Test
    void VectorSubtraction(){
        // Given
        Vector2d vector1 = new Vector2d(3, 5);
        Vector2d vector2 = new Vector2d(1, 2);

        // When
        Vector2d result = vector1.subtract(vector2);

        // Then
        assertEquals(new Vector2d(2, 3), result);
    }

    @Test
    void VectorReturnsOpposite(){
        // Given
        Vector2d vector = new Vector2d(1, -2);

        // When
        Vector2d result = vector.opposite();

        // Then
        assertEquals(new Vector2d(-1, 2), result);
    }
}
