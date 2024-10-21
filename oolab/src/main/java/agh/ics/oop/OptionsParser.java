package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;
import java.util.List;
public class OptionsParser
{
    // Statyczna metoda zamieniająca tablicę String[] na MoveDirection[]
    public static MoveDirection[] parse(String[] args) {
        List<MoveDirection> directions = new ArrayList<>();

        // Przetwarzanie każdego argumentu
        for (String arg : args) {
            switch (arg) {
                case "f":
                    directions.add(MoveDirection.FORWARD);
                    break;
                case "b":
                    directions.add(MoveDirection.BACKWARD);
                    break;
                case "r":
                    directions.add(MoveDirection.RIGHT);
                    break;
                case "l":
                    directions.add(MoveDirection.LEFT);
                    break;
                // Niepoprawne argumenty są ignorowane
                default:
                    // Ignorujemy niepoprawne argumenty
                    break;
            }
        }

        // Zamiana listy na tablicę MoveDirection[]
        return directions.toArray(new MoveDirection[0]);
    }
}
