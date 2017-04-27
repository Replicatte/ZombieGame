/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author repli
 */
public class GameObject {

    protected byte hasColision;
    protected Rectangle colisionBox;
    protected Rectangle positionBox;

    protected byte baseFrame;

    public GameObject(Rectangle colisionBox, Rectangle postionBox, byte estadoObjecto) {
        this.colisionBox = colisionBox;
        this.positionBox = postionBox;
        this.baseFrame = estadoObjecto;
        this.hasColision = 0;
    }

    public void render() {
        //gc.drawImage(,positionBox.x,positionBox.y);
    }

    public void renderTest(Graphics gc) {
        if(gc != null){ //tarda más en sacar el condicional
            gc.setColor(Color.RED);
            gc.fillRect(this.positionBox.x, this.positionBox.y, 256, 64);
       }
    }
    
    public void update(ArrayList<Byte> input){
        
    }
    
    public void update(){
        
    }
    public void update(short input){
        
    }
    
    public void update(double interval){
        
    }

    public void setLocation(int x, int y) {
        this.positionBox.setLocation(x, y);
    }

    public void setXLocation(int x) {
        this.positionBox.setLocation(x, this.positionBox.y);
    }

}
