/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.game;

import java.awt.Graphics;
import java.util.ArrayList;
import projectzombie.gameobjects.*;
import projectzombie.gameobjects.Character;
import projectzombie.motor.Window;

/**
 *
 * @author
 */
public class Game {

    public static Graphics contextoGrafico;
    private ArrayList<GameObject> objetosJuego;
    private Window window;

    public Game(ArrayList<GameObject> objetosJuego, Window window) {
        this.objetosJuego = objetosJuego;
        this.window = window;
//        this.contextAux = buffAux.getCanvas().getGraphicsContext2D();       
    }

//    private Image buffAux = new Image(new InputStreamAdapter, Window.SCREEN_WIDTH,Window.SCREEN_HEIGHT, true, true);
//    private GraphicsContext contextAux;        contextoGrafico.drawImage(buffAux, 0, 0);
    public void renderAll() {
        contextoGrafico = window.graphicsContext();
        try {
            for (GameObject obj : objetosJuego) {
                        if (obj instanceof Character) {
                            obj.render();
                        } else {
                            obj.renderTest(contextoGrafico);
                       }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        window.repaint();
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
