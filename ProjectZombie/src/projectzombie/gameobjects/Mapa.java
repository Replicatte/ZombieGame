/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import projectzombie.motor.Window;

/**
 *
 * @author repli
 */
public class Mapa extends GameObject {

    public Mapa(Rectangle colisionBox, Rectangle postionBox, byte estadoObjecto) {
        super(colisionBox, postionBox, estadoObjecto);
    }

    @Override
    public void renderTest(Graphics gc) {
         if(gc != null){ //tarda más en sacar el condicional
            gc.setColor(java.awt.Color.lightGray);
            gc.fillRect(0, 0, Window.SCREEN_WIDTH,  Window.SCREEN_HEIGHT);
       }
        
    }

    
}
