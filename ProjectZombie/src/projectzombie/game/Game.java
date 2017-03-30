/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.game;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.canvas.GraphicsContext;
import projectzombie.gameobjects.*;
import projectzombie.gameobjects.Character;

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
    }

    public void renderAll() {
        for (GameObject obj : objetosJuego) {
            obj.renderTest(contextoGrafico);
        }

    }
 
    public void updateAll(double interval) {
        
        //POSIBLE IMPLEMENTACIÓN, PASAR ARRAYLIST DE STRING INPUT A BYTES,
        // RESTRINGIGIR VALORES 
        
        if (!objetosJuego.isEmpty()) {
            for (GameObject go : objetosJuego) {
                if (go instanceof Character) {
                    go.update(window.input);
                } else{
                    go.update(interval);
                    
                }
            }
        }
    }

}
