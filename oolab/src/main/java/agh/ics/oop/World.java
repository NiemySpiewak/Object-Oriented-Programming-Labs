package agh.ics.oop;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.MapDirection;

public class World
{
    public static void main(String[] args)
    {

        System.out.println("System wystartowal");
        MoveDirection[] directions = OptionsParser.parse(args);

        run(directions);
        System.out.println("System zakonczyl dzialanie");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);

        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

    }
    public static void run(MoveDirection[] directions)
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
