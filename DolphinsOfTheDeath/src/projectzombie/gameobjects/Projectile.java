/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import projectzombie.fisicas.ChrPhys;
import projectzombie.game.Camara;

/**
 *
 * @author saulc
 */
public class Projectile extends GameObject{
    
    public static byte bulletCount;
    public static Projectile[] VectorProyectiles = new Projectile[10];
    private ChrPhys fisicas;
    
    public Projectile(Rectangle colisionBox, Rectangle postionBox, byte estadoObjecto) {
        super(colisionBox, postionBox, estadoObjecto);
        
        this.fisicas = new ChrPhys();
        this.fisicas.velX = 0;
        this.fisicas.velY = 0;
        this.fisicas.accelX = 0;
        this.fisicas.accelY = 0;
        
        ++bulletCount;
    }
    
    public void setPhysics(byte vX, byte vY, byte aX, byte aY) {
        this.fisicas.velX = vX;
        this.fisicas.velY = vY;
        this.fisicas.accelX = aX;
        this.fisicas.accelY = aY;
    }
    
    
    @Override
    public void renderTest(Graphics gc) {
        gc.setColor(Color.BLUE);
        gc.fillRect(this.positionBox.x - Camara.offsetX, this.positionBox.y - Camara.offsetY, this.positionBox.width, this.positionBox.height);        
    }
    
    @Override
    public void update(double interval){
        if(((int)this.fisicas.velX) + this.fisicas.accelX > Byte.MAX_VALUE){
            this.fisicas.velX = Byte.MAX_VALUE;
        } else if(((int)this.fisicas.velX) + this.fisicas.accelX < Byte.MIN_VALUE){
            this.fisicas.velX = Byte.MIN_VALUE;
        } else {
            this.fisicas.velX += this.fisicas.accelX;
        }
        
        if(((int)this.fisicas.velY) + this.fisicas.accelY > Byte.MAX_VALUE){
            this.fisicas.velY = Byte.MAX_VALUE;
        } else if(((int)this.fisicas.velY) + this.fisicas.accelY < Byte.MIN_VALUE){
            this.fisicas.velY = Byte.MIN_VALUE;
        } else {
            this.fisicas.velY += this.fisicas.accelY;
        }
        
        this.positionBox.x += this.fisicas.velX;
        this.positionBox.y += this.fisicas.velY;
        
        this.setLocation(positionBox.x, positionBox.y);
    }   
}
