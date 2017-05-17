/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.utils;

/**
 *
 * @author repli
 */
public class Animation {

    private static byte charTick = 0;

    //Cada vez que charTick supere el condicional se pasa al siguiente frame
    public static byte nuevoFrameEstatico(byte frameAnterior) {

        if (frameAnterior <= 32) {
            charTick++;
            if (charTick > 22) {
                charTick = 0;
                byte nuevoFrame = (byte) (frameAnterior + 1);
                return nuevoFrame;
            }
            return frameAnterior;
        } else {

            charTick++;
            if (charTick > 10) {
                charTick = 0;
                byte nuevoFrame = (byte) (frameAnterior + 1);
                return nuevoFrame;
            }
            return frameAnterior;
        }

    }

    private static byte resetTick = 0;

    // Este metodo se encarga de el delay del cambio de la vuelta a estadoBase.
    public static byte nuevoFrameEstatico(byte frameAnterior, byte estadoBase) {
        if (frameAnterior < 32) {
            resetTick++;
            if (resetTick > 22) {
                resetTick = 0;
                return estadoBase;
            }
            return frameAnterior;
        } else {
            resetTick++;
            if (resetTick > 10) {
                resetTick = 0;
                return estadoBase;

            }
            return frameAnterior;
        }
        
    }

}