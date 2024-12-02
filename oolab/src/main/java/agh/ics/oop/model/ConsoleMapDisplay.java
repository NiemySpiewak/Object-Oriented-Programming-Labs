package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    //otrzymaną informację o operacji wykonanej na mapie,
    //wizualną reprezentację otrzymanej mapy (toString()),
    //sumaryczną liczbę wszystkich otrzymanych do tej pory aktualizacji (zdefiniuj odpowiedni atrybut)
    private int updateCount = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message)
    {
        updateCount++;
//        synchronized (System.out) {
//        System.out.println("Updates counter: " + updateCount);
//        System.out.println("Notification: " + message);
//        System.out.println("Mapa ID: " + worldMap.getId());
//        }
        System.out.println("Updates counter: " + updateCount);
        System.out.println("Notification: " + message);
        System.out.println("Mapa ID: " + worldMap.getId());
        System.out.println(worldMap);
    }
}
