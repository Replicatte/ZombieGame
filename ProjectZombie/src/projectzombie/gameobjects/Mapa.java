/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.gameobjects;

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

    public void renderTest(GraphicsContext gc) {

        gc.setFill(Color.SALMON);

        gc.fillRect(0,0,Window.SCREEN_WIDTH, Window.SCREEN_HEIGHT);
    }
}
