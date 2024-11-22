package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    @Test
    public void northOrientation() {
        // given
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = List.of(OptionsParser.parse(new String[]{"f", "r", "b", "l"}));
        RectangularMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(positions, directions, map);

        // when
        simulation.run();
        Animal animal = simulation.getAnimals().get(0);

        // then
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    public void southOrientation() {
        // given
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = List.of(OptionsParser.parse(new String[]{"f", "l", "b", "l"}));
        RectangularMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(positions, directions, map);

        // when
        simulation.run();
        Animal animal = simulation.getAnimals().get(0);

        // then
        assertEquals(MapDirection.SOUTH, animal.getOrientation());
    }

    @Test
    public void westOrientation() {
        // given
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = List.of(OptionsParser.parse(new String[]{"f", "l", "b", "f"}));
        RectangularMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(positions, directions, map);

        // when
        simulation.run();
        Animal animal = simulation.getAnimals().get(0);

        // then
        assertEquals(MapDirection.WEST, animal.getOrientation());
    }

    @Test
    public void eastOrientation() {
        // given
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = List.of(OptionsParser.parse(new String[]{"r", "f", "r", "b", "r", "r", "f", "r"}));
        RectangularMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(positions, directions, map);

        // when
        simulation.run();
        Animal animal = simulation.getAnimals().get(0);

        // then
        assertEquals(MapDirection.EAST, animal.getOrientation());
    }

    @Test
    public void moveNorth() {
        // given
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = List.of(OptionsParser.parse(new String[]{"f"}));
        RectangularMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(positions, directions, map);

        // when
        simulation.run();
        Animal animal = simulation.getAnimals().get(0);

        // then
        assertEquals(new Vector2d(2, 3), animal.getPosition());
    }

    @Test
    public void moveSouth() {
        // given
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = List.of(OptionsParser.parse(new String[]{"r", "r", "f"}));
        RectangularMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(positions, directions, map);

        // when
        simulation.run();
        Animal animal = simulation.getAnimals().get(0);

        // then
        assertEquals(new Vector2d(2, 1), animal.getPosition());
    }

    @Test
    public void moveEast() {
        // given
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = List.of(OptionsParser.parse(new String[]{"r", "f"}));
        RectangularMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(positions, directions, map);

        // when
        simulation.run();
        Animal animal = simulation.getAnimals().get(0);

        // then
        assertEquals(new Vector2d(3, 2), animal.getPosition());
    }

    @Test
    public void moveWest() {
        // given
        List<Vector2d> positions = List.of(new Vector2d(2, 2));
        List<MoveDirection> directions = List.of(OptionsParser.parse(new String[]{"l", "f"}));
        RectangularMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(positions, directions, map);

        // when
        simulation.run();
        Animal animal = simulation.getAnimals().get(0);

        // then
        assertEquals(new Vector2d(1, 2), animal.getPosition());
    }

    @Test
    public void blockNorthEdge() {
        // given
        List<Vector2d> positions = List.of(new Vector2d(4, 4));
        List<MoveDirection> directions = List.of(OptionsParser.parse(new String[]{"f"}));
        RectangularMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(positions, directions, map);

        // when
        simulation.run();
        Animal animal = simulation.getAnimals().get(0);

        // then
        assertEquals(new Vector2d(4, 4), animal.getPosition());
    }

    @Test
    public void blockSouthEdge() {
        // given
        List<Vector2d> positions = List.of(new Vector2d(0, 0));
        List<MoveDirection> directions = List.of(OptionsParser.parse(new String[]{"l", "l", "f"}));
        RectangularMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(positions, directions, map);

        // when
        simulation.run();
        Animal animal = simulation.getAnimals().get(0);

        // then
        assertEquals(new Vector2d(0, 0), animal.getPosition());
    }

    @Test
    public void blockEastEdge() {
        // given
        List<Vector2d> positions = List.of(new Vector2d(5, 5));
        List<MoveDirection> directions = List.of(OptionsParser.parse(new String[]{"r", "f"}));
        RectangularMap map = new RectangularMap(6, 6);
        Simulation simulation = new Simulation(positions, directions, map);

        // when
        simulation.run();
        Animal animal = simulation.getAnimals().get(0);

        // then
        assertEquals(new Vector2d(5, 5), animal.getPosition());
    }

    @Test
    public void blockWestEdge() {
        // given
        List<Vector2d> positions = List.of(new Vector2d(0, 0));
        List<MoveDirection> directions = List.of(OptionsParser.parse(new String[]{"l", "f"}));
        RectangularMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(positions, directions, map);

        // when
        simulation.run();
        Animal animal = simulation.getAnimals().get(0);

        // then
        assertEquals(new Vector2d(0, 0), animal.getPosition());
    }

    @Test
    public void twoAnimalsOneSurvives() {
        // given
        List<MoveDirection> directions = List.of(OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f"}));
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(2, 2));
        RectangularMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(positions, directions, map);

        // when
        simulation.run();
        List<Animal> animals = simulation.getAnimals();

        // then
        assertEquals(1, animals.size());
        Animal animal1 = animals.get(0);
        assertTrue(animal1.getPosition().follows(new Vector2d(0, 0)));
        assertTrue(animal1.getPosition().precedes(new Vector2d(4, 4)));
        assertEquals(animal1.getOrientation(), MapDirection.SOUTH);
        assertEquals(animal1.getPosition(), new Vector2d(2, 0));
    }

}