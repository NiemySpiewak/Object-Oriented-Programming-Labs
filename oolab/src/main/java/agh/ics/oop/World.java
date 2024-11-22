package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.List;

import static agh.ics.oop.OptionsParser.parse;

public class World
{
    public static void main(String[] args)
    {

        System.out.println("System wystartowal");

        GrassField map = new GrassField(10);
        List<MoveDirection> directions = List.of(OptionsParser.parse(args));
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));


        ConsoleMapDisplay consoleDisplay = new ConsoleMapDisplay();
        map.addObserver(consoleDisplay);


        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();

        run(directions);
        System.out.println("System zakonczyl dzialanie");

    }
    public static void run(List<MoveDirection> directions)
    {
        for (MoveDirection direction : directions) {
            switch (direction) {
                case FORWARD:
                    System.out.println("Zwierzak do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak do tylu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak w lewo");
                    break;
            }
        }
    }
}
