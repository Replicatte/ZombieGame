/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.motor;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import projectzombie.game.GameInit;
import static projectzombie.game.GameInit.gcReady;

/**
 *
 * @author repli
 */
public class Window extends Application {

    public static ArrayList<Byte> input;

    GraphicsContext gc;

    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;

    public static void principal(String[] args) {
        input = new ArrayList<>();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("ZombieProject");
        Group root = new Group();
        Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        root.getChildren()
                .add(canvas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {

                System.exit(0);
            }
        });

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                Byte byteCode = -1;

                switch (event.getCode()) {
                    case A:
                        byteCode = 0;
                        break;
                    case D:
                        byteCode = 1;
                        break;
                    case W:
                        byteCode = 2;
                        break;
                    case S:
                        byteCode = 3;
                        break;
                    default:
                        byteCode = -1;
                        throw new AssertionError(event.getCode().name());
                }

                if (!input.contains(byteCode)) {
                    input.add(byteCode);
//                    System.out.println("INPUT AÑADIDA ->" + input.toString() );//aço si es pilla
                }
            }
        }
        );

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
//                System.out.println("INPUT BORRADA ->" + code );//aço si es pilla
                Byte byteCode = -1;
                switch (event.getCode()) {
                    case A:
                        byteCode = 0;
                        break;
                    case D:
                        byteCode = 1;
                        break;
                    case W:
                        byteCode = 2;
                        break;
                    case S:
                        byteCode = 3;
                        break;
                    default:
                        byteCode = -1;
                        throw new AssertionError(event.getCode().name());
                }
                input.remove(byteCode);
            }
        }
        );

        System.out.println("Hola, me encuentro en la ventana");
        primaryStage.show();
        System.out.println(" Esto es post ventana.");

        GameInit.darConextoGrafico(gc);
        gcReady = true;
    }

    private void drawing(GraphicsContext gc) {

        gc.setFill(Color.DARKBLUE);
        gc.fillRect(0, 0, 10, 10);
    }

    public GraphicsContext getGraphicsContext() {
        return gc;
    }
}
