/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import projectzombie.motor.Window;
import java.awt.Color;
import projectzombie.game.Camara;

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
        gc.setColor(Color.LIGHT_GRAY);
        gc.fillRect(-Camara.offsetX, -Camara.offsetY, Window.screen_width, Window.screen_height);
    }
}
