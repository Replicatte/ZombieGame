/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import projectzombie.gameobjects.*;
import projectzombie.gameobjects.Character;
import projectzombie.motor.*;

/**
 *
 * @author Saul&JordiCorporation
 */
public class GameInit {

    private static Graphics contextoGrafico;

    public static void iniciarJuego(String[] args) {

        //TAL VEZ ANIMACIÓN DE LOADING CON SU PROPIO ESTADO DE JUEGO?
        Window w = new Window();

        w.setLocationRelativeTo(null);
        w.setResizable(false);
        w.setBackground(Color.RED);
        w.setVisible(true);
        ImageManager.generateImages();

        ArrayList<GameObject> ago = new ArrayList<>();
        //Inicialización del Vector de Proyectiles
        for(int i = 0; i < Projectile.VectorProyectiles.length; ++i) {
            Projectile.VectorProyectiles[i] = new Projectile(new Rectangle(10,10), new Rectangle(0,0,10,10), 
                                                (byte)-1);
        }
        
        //Creación de GameObject y pasarselos a GAME
        Character chara = new Character(new Rectangle(50, 50),
                new Rectangle(Window.screen_width >> 1,
                        Window.screen_height >> 1, 64, 64), (byte) 0);
        

        Zombie zombie1 = new Zombie(new Rectangle(50, 50),
                new Rectangle(100, 200, 64, 64), (byte) 0);

        Decoration decor1 = new Decoration(new Rectangle(50, 50),
                new Rectangle(0, 0, 128, 128), (byte) 0);

        Decoration decor2 = new Decoration(new Rectangle(50, 50),
                new Rectangle(257, 257, 128, 128), (byte) 0);

        Mapa map = new Mapa(new Rectangle(50, 50),
                new Rectangle(100, 200, 200, 200), (byte) 0);

        ago.add(map);
        ago.add(decor1);
        ago.add(decor2);
        ago.add(chara);
        ago.add(zombie1);
        for(int i = 0; i < Projectile.VectorProyectiles.length; ++i) {
            ago.add(Projectile.VectorProyectiles[i]);
        }

        //Asignación del foco a la camara
        Camara.setFocus(chara.getPosition());
        //Creación de la partida -> bucle -> START
        Game juego = new Game(contextoGrafico, ago, w);

        GameLoop bucleJuego = new GameLoop(juego);

        bucleJuego.start();

    }
}
