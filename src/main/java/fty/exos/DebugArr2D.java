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
public class DebugArr2D {
    public static char[] initializedArray(char c, int nb){
        char[] res= new char[nb];
        for(int i=0; i != res.length; ++i){
            res[i]= c;
        }
        return res;
    }
    public static char[][] initializedArray2D(char[] arr, int nb){
        char[][] res= new char[nb][];
        for(int i=0; i != res.length; ++i){
            res[i]= arr;
        }
        return res;
    }
    public static void display(char[][] arr2D){
        for(char[] row : arr2D){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        char[][] screen= initializedArray2D(initializedArray(' ', 20), 20);
        for(int i= 0; i != Math.min(screen.length, screen[0].length); ++i){
            screen[i][i]='X';
            screen[screen.length-i-1][i]='X';
        }
        display(screen);
    }
}
