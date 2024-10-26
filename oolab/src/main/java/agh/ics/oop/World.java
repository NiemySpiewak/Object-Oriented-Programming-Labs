package agh.ics.oop;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.MapDirection;

public class World
{
    public static void main(String[] args)
    {
        // Test metody toString
        MapDirection direction = MapDirection.EAST;
        System.out.println(direction);

        // Test metody next
        System.out.println(direction.next());
        // Test metody previous
        System.out.println(direction.previous());

        // Test metody toUnitVector
        Vector2d unitVector = direction.toUnitVector();
        System.out.println(unitVector);




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
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tylu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak skreca w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak skreca w lewo");
                    break;
            }
        }
    }
}
