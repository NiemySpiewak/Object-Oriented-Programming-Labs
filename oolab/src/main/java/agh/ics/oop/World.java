package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World
{
    public static void main(String[] args)
    {
        System.out.println("System wystartowal");
        // Zamiana tablicy args na tablicę MoveDirection[] za pomocą OptionsParser
        MoveDirection[] directions = OptionsParser.parse(args);

        // Wywołanie metody run z przekazaniem tablicy MoveDirection[]
        run(directions);
        System.out.println("System zakonczyl dzialanie");
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
