package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

import static agh.ics.oop.OptionsParser.parse;

public class World
{
    public static void main(String[] args)
    {

        System.out.println("System wystartowal");

        try {
            List<MoveDirection> directions = List.of(OptionsParser.parse(args));
            List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
            AbstractWorldMap map1 = new GrassField(10);
            AbstractWorldMap map2 = new RectangularMap(5, 5);
            map1.addObserver(new ConsoleMapDisplay());
            map2.addObserver(new ConsoleMapDisplay());
            Simulation simulation1 = new Simulation(positions, directions, map1);
            Simulation simulation2 = new Simulation(positions, directions, map2);
            SimulationEngine engine = new SimulationEngine(List.of(simulation1, simulation2));
            //engine.runSync();
            //engine.runAsync();
            engine.runAsyncInThreadPool();

//            List<MoveDirection> directions = List.of(parse(args));
//            List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
//            List<Simulation> simulations = new ArrayList<>();
//            for (int i = 0; i < 10000; i++) {
//                AbstractWorldMap map = i % 2 == 0 ? new GrassField(10) : new RectangularMap(5, 5);
//                map.addObserver(new ConsoleMapDisplay());
//                Simulation simulation = new Simulation(positions, directions, map);
//                simulations.add(simulation);
//            }
//            SimulationEngine engine = new SimulationEngine(simulations);
//            engine.runAsyncInThreadPool();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
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
