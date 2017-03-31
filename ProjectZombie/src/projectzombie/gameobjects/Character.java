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
import projectzombie.Fisicas.ChrPhys;
import projectzombie.Utils.Maths;

/**
 *
 * @author repli
 */
public class Character extends GameObject {

    private ChrPhys fisicas;

    public Character(Rectangle colisionBox, Rectangle postionBox, byte estadoObjecto) {
        /*
        *   POSIBLES ESTADOS DE PERSONAJE:
        *
        *   -static izq ->0
        *   -static der ->4
        *   -static top ->8
        *   -static down ->12
        
        *   -static izqtop ->16
        *   -static izqdown ->20
        *   -static dertop ->24
        *   -static derdown ->28
        *
        *
        *
        *   -moving izq1 ->1
        *   -moving izq2 ->2
        *   -moving izq3 ->3
        *   .........................
         */

        super(colisionBox, postionBox, estadoObjecto);
        this.hasColision = 1;
        fisicas = new ChrPhys();
        fisicas.velX = 0;
        fisicas.velY = 0;

    }
    private static final int pasoUpdate = 8;

    private boolean dirizq = true;
    private boolean dirarriba = true;

    public void update(ArrayList<Byte> input) {
        if (!input.isEmpty()) {

            if (input.size() >= 2 && (fisicas.velX < 100 && fisicas.velY < 100)) {
                switch (input.get(0)) {
                    case 0:
                        fisicas.velX = -pasoUpdate;
                        dirizq = true;
                        break;
                    case 1:
                        fisicas.velX = pasoUpdate;
                        dirizq = false;
                        break;
                    case 2:
                        fisicas.velY = -pasoUpdate;
                        dirarriba = true;
                        break;
                    case 3:
                        fisicas.velY = pasoUpdate;
                        dirarriba = false;
                        break;

                }
                switch (input.get(1)) {
                    case 0:
                        fisicas.velX = -pasoUpdate;
                        dirizq = true;
                        break;
                    case 1:
                        fisicas.velX = pasoUpdate;
                        dirizq = false;
                        break;
                    case 2:
                        fisicas.velY = -pasoUpdate;
                        dirarriba = true;
                        break;
                    case 3:
                        fisicas.velY = pasoUpdate;
                        dirarriba = false;
                        break;

                }

                if (dirizq) {
                    if (dirarriba) {
                        //izqtop
                        estadoObjecto = 16;
                    } else {  //izqdown

                        estadoObjecto = 20;
                    }
                }
                if (!dirizq) {
                    if (dirarriba) {
                        //dertop
                        estadoObjecto = 24;
                    } else { //derbajo
                        estadoObjecto = 28;
                    }

                }

            } else {//Solo presionado un boton

                if (fisicas.velX < 100 && fisicas.velY < 100) {

                    switch (input.get(0)) {
                        case 0:
                            fisicas.velX = -pasoUpdate;
                            fisicas.velY = 0;
                            estadoObjecto = 0;
                            break;

                        case 1:
                            fisicas.velX = pasoUpdate;
                            fisicas.velY = 0;
                            estadoObjecto = 4;
                            break;

                        case 2:
                            fisicas.velY = -pasoUpdate;
                            fisicas.velX = 0;
                            estadoObjecto = 8;
                            break;

                        case 3:
                            fisicas.velY = pasoUpdate;
                            fisicas.velX = 0;
                            estadoObjecto = 12;
                            break;
                    }
                }
            }
            setLocation(this.positionBox.x += fisicas.velX, this.positionBox.y += fisicas.velY);

        } else {
            fisicas.velX = Maths.normalize(fisicas.velX);
            fisicas.velY = Maths.normalize(fisicas.velY);

            setLocation(this.positionBox.x += fisicas.velX, this.positionBox.y += fisicas.velY);
        }
    }

    @Override
    public void renderTest(GraphicsContext gc) {

        gc.setFill(Color.BLUE);

        gc.fillRect(positionBox.getX(), positionBox.getY(), positionBox.getWidth(), positionBox.getHeight());
        if (estadoObjecto == 0 || estadoObjecto == 16 || estadoObjecto == 20) //left
        {
            gc.fillPolygon(
                    new double[]{
                        positionBox.getX() - 16,
                        positionBox.getX() - 32,
                        positionBox.getX() - 16
                    },
                    new double[]{
                        positionBox.getY(),
                        positionBox.getY() + 32,
                        positionBox.getY() + 64
                    },
                    3);
        }

        if (estadoObjecto == 4 || estadoObjecto == 24 || estadoObjecto == 28) //right
        {
            gc.fillPolygon(
                    new double[]{
                        positionBox.getX() + 80,
                        positionBox.getX() + 96,
                        positionBox.getX() + 80
                    },
                    new double[]{
                        positionBox.getY(),
                        positionBox.getY() + 32,
                        positionBox.getY() + 64
                    },
                    3);
        }

        if (estadoObjecto == 8 || estadoObjecto == 16 || estadoObjecto == 24) //top
        {
            gc.fillPolygon(
                    new double[]{
                        positionBox.getX(),
                        positionBox.getX() + 32,
                        positionBox.getX() + 64
                    },
                    new double[]{
                        positionBox.getY() - 16,
                        positionBox.getY() - 32,
                        positionBox.getY() - 16
                    },
                    3);
        }

        if (estadoObjecto == 12 || estadoObjecto == 20 || estadoObjecto == 28) //down
        {
            gc.fillPolygon(
                    new double[]{
                        positionBox.getX(),
                        positionBox.getX() + 32,
                        positionBox.getX() + 64
                    },
                    new double[]{
                        positionBox.getY() + 80,
                        positionBox.getY() + 96,
                        positionBox.getY() + 80
                    },
                    3);
        }

    }

}
