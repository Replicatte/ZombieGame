/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.gameobjects;

import java.awt.Rectangle;
import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import projectzombie.Utils.Maths;
import projectzombie.game.GameInit;

/**
 *
 * @author repli
 */
public class Zombie extends Enemie {
//     byte hasColision;
//     Rectangle colisionBox;
//     Rectangle positionBox;
//    
//     byte estadoObjecto;

    public Zombie(Rectangle colisionBox, Rectangle postionBox, byte estadoObjecto) {
        super(colisionBox, postionBox, estadoObjecto);
        this.hasColision = 1;
    }

    @Override
    public void renderTest(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.fillRect(this.positionBox.getX(), this.positionBox.getY(), this.positionBox.getWidth(), this.positionBox.getHeight());
    }

    @Override
    public void update(double interval) {
//        && input.get(0).equals("SPACE")
//         if (!input.isEmpty()) {
            float value = (float) (30 * interval);// una vez esto sea mayor a uno se lanza como un loco.
            positionBox.x = (int)(positionBox.x + value);
            this.setXLocation((int)(positionBox.x * interval));
        
//        }
    }
}
