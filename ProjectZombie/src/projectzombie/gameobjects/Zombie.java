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
    public void update(ArrayList<Byte> input) {
//        && input.get(0).equals("SPACE")
        if (!input.isEmpty()) {
            this.setLocation(this.positionBox.x += Maths.genRandom(-2, 2), this.positionBox.y += Maths.genRandom(-2, 2));
        }

    }
}
