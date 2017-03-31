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

    public static short input;
    
    GraphicsContext gc;

    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;

    public static void principal(String[] args) {
        input = (short)0b1000000000000000;

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
                switch (event.getCode()) {
                    case A://posicion 0 input
                        if((input & 0b1)== 0){
                            ++input;
                        }
                        break;
                    case D://posicion 2 input
                        if((input & 0b10) == 0){
                            input += 2;
                        }
                        break;
                    case W://posicion 3
                        if((input & 0b100) == 0){
                            input += 4;
                        }
                        break;
                    case S://posicion 4
                        if((input & 0b1000) == 0){
                            input += 8;
                        }
                        break;
                }
            }
        }
        );

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
//                System.out.println("INPUT BORRADA ->" + code );//aço si es pilla      
                switch (event.getCode()) {
                    case A:
                        --input;
                        break;
                    case D:
                        input -= 2;
                        break;
                    case W:
                        input -= 4;
                        break;
                    case S:
                        input -= 8;
                        break;
                }
            }
        }
        );

        primaryStage.show();
        System.out.println("VENTANA MOSTRADA");
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
