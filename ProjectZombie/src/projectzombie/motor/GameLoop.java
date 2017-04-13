/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.motor;

import java.util.logging.Level;
import java.util.logging.Logger;
import projectzombie.game.Game;
/**
 *
 * @author repli
 */
public class GameLoop extends Thread {

    public static final int TARGET_FPS = 60;

    public static final int TARGET_UPS = 30;

    private final Timer timer;

    private Game ourGame;

    public GameLoop(Timer timer, Game ourGame) {
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
            gameLoop2();
        } catch (Exception excp) {
            excp.printStackTrace();
        } finally {

        }
    }

    int lastFpsTime;
    int fps;

    protected void gameLoop2() {
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        boolean coin = true;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        while (true) {
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double) OPTIMAL_TIME);
            lastFpsTime += updateLength;
            fps++;

            if (lastFpsTime >= 1000000000){
                System.out.println("(FPS: " + fps + ")");
                lastFpsTime = 0;
                fps = 0;
            }
            ourGame.updateAll(delta);
            //if(coin){
            ourGame.renderAll();
            //    coin = !coin;
            //} else {
            //    coin = !coin;
            //}

            try {
                long tiempoEsperaReal = lastLoopTime - System.nanoTime();
                if(tiempoEsperaReal < 0){
                    tiempoEsperaReal = 0;
                }
                Thread.sleep(tiempoEsperaReal + OPTIMAL_TIME / 1000000);

            } catch (InterruptedException ex) {
                Logger.getLogger(GameLoop.class.getName()).log(Level.SEVERE, null, ex);
            }  catch (Exception e) {
                System.out.println(e + "\n TE LO DIJE!!");
            }
        }
    }

    protected void gameLoop() {

        double elapsedTime;

        double accumulator = 0f;

        double interval = 1f / TARGET_UPS;//Número renders per update?

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
//            
            while (accumulator >= interval) {
                ourGame.updateAll(interval);
                accumulator -= interval;
// inteval sempre 0,03

            }
//            int k = 0;
//            while (k < TARGET_UPS) {
//                ourGame.updateAll(interval);
//                k++;
//            }

            //ourGame.renderAll();

            sync();

        }

    }

    private void sync() {

        double loopSlot = 1f / TARGET_FPS;

        double endTime = timer.getLastLoopTime() + loopSlot;

        while (timer.getTime() < endTime) {

            try {

                this.sleep(1);

            } catch (InterruptedException ie) {
                System.out.println("FALLOOOOOOO DE INTERRUPCION");
            } catch (Exception e) {
                System.out.println(e + "\n" + e.getCause());
            }

        }

    }

}
