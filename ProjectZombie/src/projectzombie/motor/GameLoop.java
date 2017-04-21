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

    private Game ourGame;

    public GameLoop(Game ourGame) {
        this.ourGame = ourGame;
    }
    
    
    @Override
    public void run() {
        try {
            gameLoop();
        } catch (Exception excp) {
            excp.printStackTrace();
        } finally {

        }
    }

    int lastFpsTime;
    int fps;

    protected void gameLoop() {
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
            
            //Update ^ Render
            ourGame.updateAll(delta);
            ourGame.renderAll();

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
}
