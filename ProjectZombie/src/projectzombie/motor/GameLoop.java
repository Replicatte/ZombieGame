/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.motor;

import java.util.ArrayList;
import projectzombie.game.Game;
import projectzombie.motor.Timer;

/**
 *
 * @author repli
 */
public class GameLoop extends Thread {

    public static final int TARGET_FPS = 30;

    public static final int TARGET_UPS = 30;

    private final Timer timer;

    private Game ourGame;

    public GameLoop(Timer timer, Game ourGame, Window window) {
        this.timer = timer;
        this.ourGame = ourGame;
    }

//    @Override
//    public void run() {
//        
//        
//        //input()
//        
//        //update()
//        //render()
//    }
    @Override
    public void run() {
        try {
            gameLoop();

        } catch (Exception excp) {

            excp.printStackTrace();

        } finally {

        }

    }

    protected void gameLoop() {

        double elapsedTime;

        double accumulator = 0f;

        double interval = 1f / TARGET_UPS;

        boolean running = true;

        while (running) {

            elapsedTime = timer.getElapsedTime();

            accumulator += elapsedTime;
//ERA PER COMPILAR Y VORE ON ESTABA EL ERROR, NO PILLA MAY RES EN INPUT SEMPRE ES NULL
//Game.getInput();
//            ArrayList input = window.getInput();
//            if (window.input!= null){ 
//                System.out.println("INPUT NO VACIA EN LOOP :D" + window.input);
//            }

            while (accumulator >= interval ) {
                ourGame.updateAll(interval);
                accumulator -= interval;

            }
          
            
            
            ourGame.renderAll();

            sync();

        }

    }

    private void sync() {

        double loopSlot = 1f / TARGET_FPS;

        double endTime = timer.getLastLoopTime() + loopSlot;

        while (timer.getTime() < endTime) {

            try {

                Thread.sleep(1);

            } catch (InterruptedException ie) {

            }

        }

    }

}
