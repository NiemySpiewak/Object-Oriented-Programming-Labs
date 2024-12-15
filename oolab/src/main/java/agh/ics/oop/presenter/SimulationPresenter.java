package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.List;


public class SimulationPresenter implements MapChangeListener {
    private WorldMap worldMap;
    private final int CELL_WIDTH = 25;
    private final int CELL_HEIGHT = 25;
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;
    private int mapWidth;
    private int mapHeight;

    @FXML
    private Label infoLabel;
    @FXML
    private TextField movesInput;
    @FXML
    private Label moveDescriptionLabel;
    @FXML
    private Button startSimulationButton;
    @FXML
    private GridPane mapGrid;

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void drawMap() {
        clearGrid();
        updateBounds();
        drawGrid();
    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    public void updateBounds() {
        Boundary boundary = worldMap.getCurrentBounds();
        xMin = boundary.lowerLeft().getX();
        xMax = boundary.upperRight().getX();
        yMin = boundary.lowerLeft().getY();
        yMax = boundary.upperRight().getY();
        mapWidth = xMax - xMin;
        mapHeight = yMax - yMin;
    }

    public void drawGrid() {

        for (int i = 0; i < mapWidth + 1; i++) {
            mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
        }

        for (int i = 0; i < mapHeight + 1; i++) {
            mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
        }

        Label label = new Label("y\\x");
        mapGrid.add(label, 0, 0);
        GridPane.setHalignment(label, HPos.CENTER);

        for (int i = 0; i < mapWidth + 1; i++) {
            label = new Label(Integer.toString(i + xMin));
            mapGrid.add(label, i + 1, 0);
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for (int i = 0; i < mapHeight + 1; i++) {
            label = new Label(Integer.toString(yMax - i));
            mapGrid.add(label, 0, i + 1);
            GridPane.setHalignment(label, HPos.CENTER);
        }

        String labelText;
        for (int x = xMin; x < xMax + 1; x++) {
            for (int y = yMin; y < yMax + 1; y++) {
                Vector2d position = new Vector2d(x, y);
                labelText = worldMap.isOccupied(position) ? worldMap.objectAt(position).toString() : " ";
                label = new Label(labelText);
                mapGrid.add(label, x - xMin + 1, yMax - y + 1);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }
    }


    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(() -> {
            moveDescriptionLabel.setText(message);
            drawMap();
        });
    }


    public void onSimulationStartClicked(ActionEvent actionEvent) {
        String moves = movesInput.getText();

        List<MoveDirection> directions = List.of(OptionsParser.parse(moves.split(" ")));
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        GrassField grassField = new GrassField(10);
        ConsoleMapDisplay consoleGrassFieldDisplay = new ConsoleMapDisplay();
        grassField.addObserver(consoleGrassFieldDisplay);
        setWorldMap(grassField);
        grassField.addObserver(this);


        new Thread(() -> {
            Simulation simulation = new Simulation(positions, directions, grassField);
            SimulationEngine simulationEngine = new SimulationEngine(List.of(simulation));
            simulationEngine.runAsync();
        }).start();

    }
}

