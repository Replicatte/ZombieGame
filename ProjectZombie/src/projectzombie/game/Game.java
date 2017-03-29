/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.game;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.canvas.GraphicsContext;
import projectzombie.gameobjects.Enemie;
import projectzombie.gameobjects.GameObject;
import projectzombie.motor.Window;

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
        velX = 0;
        velY = 0;
        posX = 100;
        posY = 200;
    }

    public void renderAll() {
        for (GameObject obj : objetosJuego) {
            obj.renderTest(contextoGrafico);
        }

    }
    int k = 0;

    int velX;
    int velY;

    int posX;
    int posY;

    public void updateAll(float interval) {
        
        //POSIBLE IMPLEMENTACIÓN, PASAR ARRAYLIST DE STRING INPUT A BYTES,
        // RESTRINGIGIR VALORES 
        if (!objetosJuego.isEmpty()) {
            for (GameObject go : objetosJuego) {
                go.update(window.input);
            }
        }
    }

}
