package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.List;

public class World
{
    public static void main(String[] args)
    {

        System.out.println("System wystartowal");
        List<MoveDirection> directions = List.of(OptionsParser.parse(args));
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        MoveValidator validator = new RectangularMap(10, 10);
        Simulation simulation = new Simulation(positions, directions, validator);
        simulation.run();

        run(directions);
        System.out.println("System zakonczyl dzialanie");

        //Vector2d position1 = new Vector2d(1,2);
        //System.out.println(position1);

        //Vector2d position2 = new Vector2d(-2,1);
        //System.out.println(position2);
        //System.out.println(position1.add(position2));

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
