/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.exos;

/**
 *
 * @author utilisateur
 */
public class Mystere {

    public static void main(String[] args) {
        System.out.println(mystere(0.01f));
    }

    public static float mystere(float epsilon) {
        return mystere(0.f, Float.MAX_VALUE, epsilon);
    }

    public static float mystere(float min, float max, float epsilon) {
        while ((max != min)) {
            float m = max / 2 + min / 2;
            if ((m + epsilon) > m) {
                min = Math.nextUp(m);
            } else {
                max = m;
            }
        }
        return min;
    }
}
