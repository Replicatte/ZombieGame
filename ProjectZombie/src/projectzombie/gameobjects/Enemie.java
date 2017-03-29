/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.gameobjects;

import java.awt.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author repli
 */
public class Enemie extends GameObject {

    public Enemie(Rectangle colisionBox, Rectangle postionBox, byte estadoObjecto) {
        super(colisionBox, postionBox, estadoObjecto);
        this.hasColision = 1;
    }

    @Override
    public void renderTest(GraphicsContext gc) {
        gc.setFill(Color.PURPLE);

        gc.fillRect(positionBox.getX(), positionBox.getY(), positionBox.getWidth(), positionBox.getHeight());
    }

}
