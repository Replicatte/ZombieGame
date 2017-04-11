/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.motor;

/**
 *
 * @author repli
 */
public class Animation {

    private static byte charTick = 0;

    public static int nuevoEstadoChar(int estadoAnterior) {
        charTick++;

        if (charTick > 22) {

            charTick = 0;
            int nuevaEstado = estadoAnterior +1;
            return nuevaEstado;
        }

        return estadoAnterior;
    }

}
