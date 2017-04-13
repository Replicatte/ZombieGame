/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.game;

import java.awt.Graphics;
import java.awt.Rectangle;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.logging.Level;
import java.util.logging.Logger;
import projectzombie.gameobjects.GameObject;
import projectzombie.gameobjects.Character;
import projectzombie.gameobjects.Mapa;
import projectzombie.gameobjects.Zombie;
import projectzombie.motor.GameLoop;
import projectzombie.motor.ImageManager;
import projectzombie.motor.Timer;
import projectzombie.motor.Window;

/**
 *
 * @author
 */
public class GameInit {

//    // Para la espera del contextografico
//    public static Lock lckGC;
    private static Graphics contextoGrafico;

    public static Condition contextoGraficoCreado;

    public static boolean gcReady;

    public static void iniciarJuego(String[] args) {
        gcReady = false;
        //TAL VEZ ANIMACIÓN DE LOADING CON SU PROPIO ESTADO DE JUEGO?
        Window w = new Window();
        new Thread() {
            @Override
            public void run() {
                //WinSenyorDeLaCeniza.main(args); //SE ENTRA EN EL METODO Y NO SE SALE
            }

        }.start();

        w.setVisible(true);
        System.out.println("--------------INICIO ESPERA------------------");

        long k = 1;
        while (!gcReady) {
            System.out.println("Pasada Bucle num: -" + k);
            try {
                sleep(15);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameInit.class.getName()).log(Level.SEVERE, null, ex);
            }
            k++;
        }

        System.out.println("--------------FIN ESPERA--------------------");
        ImageManager.generateImages();

        ArrayList<GameObject> ago = new ArrayList<>();

        //Creación de GameObject y pasarselos a GAME
        Character chara = new Character(new Rectangle(50, 50),
                new Rectangle(Window.SCREEN_WIDTH>>1-64, 
                        Window.SCREEN_HEIGHT>>1-64, 64, 64), (byte) 0);
        Zombie zombie1 = new Zombie(new Rectangle(50, 50), 
                new Rectangle(100, 200, 64, 64), (byte) 0);
        Mapa map = new Mapa(new Rectangle(50, 50), 
                new Rectangle(100, 200, 200, 200), (byte) 0);
        ago.add(map);
        ago.add(chara);
        ago.add(zombie1);

        Game juego = new Game(contextoGrafico, ago, w);

        GameLoop bucleJuego = new GameLoop(new Timer(), juego);

        bucleJuego.start();

    }

    public static void darConextoGrafico(Graphics gc) {
        contextoGrafico = gc;
    }
    
    
}
