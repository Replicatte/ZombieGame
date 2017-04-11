/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.game;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import projectzombie.gameobjects.*;
import projectzombie.gameobjects.Character;

import projectzombie.motor.Window;
import static projectzombie.motor.Window.input;

/**
 *
 * @author
 */
public class Game {

    private GraphicsContext contextoGrafico;
    private ArrayList<GameObject> objetosJuego;
    private Window window;

    public Game(GraphicsContext contextoGrafico, ArrayList<GameObject> objetosJuego, Window window) {
        this.contextoGrafico = contextoGrafico;
        this.objetosJuego = objetosJuego;
        this.window = window;
//        this.contextAux = buffAux.getCanvas().getGraphicsContext2D();
        
    }
    
//    private Image buffAux = new Image(new InputStreamAdapter, Window.SCREEN_WIDTH,Window.SCREEN_HEIGHT, true, true);
//    private GraphicsContext contextAux;        contextoGrafico.drawImage(buffAux, 0, 0);

    
    
    public void renderAll() {
        for (GameObject obj : objetosJuego) {
            if (obj instanceof Character){ obj.render(contextoGrafico);
            }else obj.renderTest(contextoGrafico);
        }

    }

    public void updateAll(double interval) {

        //POSIBLE IMPLEMENTACIÓN, PASAR ARRAYLIST DE STRING INPUT A BYTES,
        // RESTRINGIGIR VALORES 
        if (!objetosJuego.isEmpty()) {
            for (GameObject go : objetosJuego) {
                if (go instanceof Character) {
                    go.update(window.input);
                } else {
                    go.update(interval);

                }
            }
        }
    }

}
