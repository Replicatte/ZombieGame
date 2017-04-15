/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import projectzombie.gameobjects.*;
import projectzombie.gameobjects.Character;

import projectzombie.motor.*;

/**
 *
 * @author
 */
public class GameInit {

    private static Graphics contextoGrafico;

    public static void iniciarJuego(String[] args) {
        //TAL VEZ ANIMACIÓN DE LOADING CON SU PROPIO ESTADO DE JUEGO?
        Window w = new Window();

        w.setLocationRelativeTo(null);
        w.setResizable(false);
        w.setVisible(true);

        ImageManager.generateImages();

        ArrayList<GameObject> ago = new ArrayList<>();

        //Creación de GameObject y pasarselos a GAME
        Character chara = new Character(new Rectangle(50, 50),
                new Rectangle(Window.SCREEN_WIDTH >> 1 - 64,
                        Window.SCREEN_HEIGHT >> 1 - 64, 64, 64), (byte) 0);
        Zombie zombie1 = new Zombie(new Rectangle(50, 50),
                new Rectangle(100, 200, 64, 64), (byte) 0);

        Zombie zombie2 = new Zombie(new Rectangle(50, 50),
                new Rectangle(0, 0, 64, 64), (byte) 0);

        Mapa map = new Mapa(new Rectangle(50, 50),
                new Rectangle(0, 0, 0, 0), (byte) 0);

        
        ago.add(map);
        ago.add(chara);
        ago.add(zombie1);
        ago.add(zombie2);

        Game juego = new Game(ago, w);

        GameLoop bucleJuego = new GameLoop(new Timer(), juego);

        bucleJuego.start();
    }

    public static void darConextoGrafico(Graphics gc) {
        contextoGrafico = gc;
    }

}
