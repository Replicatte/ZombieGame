/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.gameobjects;

import java.awt.Rectangle;

/**
 *
 * @author repli
 */
public class Decoration extends GameObject {

    public Decoration(Rectangle colisionBox, Rectangle postionBox, byte estadoObjecto) {
        super(colisionBox, postionBox, estadoObjecto);
        this.hasColision = 1;
    }

}
