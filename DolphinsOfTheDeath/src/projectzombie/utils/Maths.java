/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.utils;

import java.util.Random;

/**
 *
 * @author repli
 */
public class Maths {

    public static int genRandom(int min, int max) {
        Random rand = new Random();
        
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    
    /**
     *
     * @param valor
     * @return
     */
    public static byte normalize(byte valor) {
        if (valor > 0) {
            valor-=1;
        } else if (valor < 0) {
            valor+=1;
        }
        return valor;
    }
}
