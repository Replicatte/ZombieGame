/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


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
    public void renderTest(Graphics gc) {
        gc.setColor(Color.PINK);

        gc.fillRect(positionBox.x, positionBox.y, positionBox.width, positionBox.height);
    }

}
