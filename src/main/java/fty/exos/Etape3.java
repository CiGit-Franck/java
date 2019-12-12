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
public class Etape3 {

    public static int fact(int n) {
        if (n == 0) {
            return (1);
        } else {
            return (n * fact(n - 1));
        }
    }

    private void showRow(int col) {
        for (int i = 0; i < col; i++) {
            System.out.print("+-");
        }
        System.out.print("+\n");

    }

    public void show2D(int row, int col) {
        System.out.println();
        showRow(col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("| ");
            }
            System.out.print("|\n");
            showRow(col);
        }
    }

    public static void show1D(int iter) {
        show1D(iter, 5);
    }

    public static void show1D(int iter, int step) {
        System.out.print("\n+");
        for (int i = 0; i < iter; ++i) {
            System.out.print((((i % step) < step - 1) ? "-" : "+"));
        }
        System.out.print("+\n");
    }

    public static String regle(int n) {
        return regle(n, "[", '-', '+', "]", 5);
    }

    public static String regle(int n, int p) {
        return regle(n, "[", '-', '+', "]", p);
    }

    public static String regle(int n, String begin, char fill, char div, String end, int unit) {
        String chaine = begin;
        for (int compteur = 0; compteur < n; ++compteur) {
            chaine += ((compteur + 1) % unit == 0) ? div : fill;
        }
        chaine += end;
        return chaine;
    }

    public static boolean isPalindrome(String mot) {
        StringBuffer tom = new StringBuffer();
        for (int i = mot.length() - 1; i >= 0; i--) {
            tom.append(mot.charAt(i));
        }
        return mot.contentEquals(tom);
    }
    public static boolean isPalindromeV2(String mot) {
        boolean vrai = true;
        for (int i =  0; i < mot.length() && vrai; i++) {
            if(mot.charAt(i) != mot.charAt((mot.length()-1)-i)){
                vrai = false;
            }
        }
        return vrai;
    }
    public static boolean isPalindromeV3(String mot) {
        boolean vrai = true;
        for (int i =  0; i < mot.length()/2 && vrai; i++) {
            if(mot.charAt(i) != mot.charAt((mot.length()-1)-i)){
                vrai = false;
            }
        }
        return vrai;
    }

    public static boolean isPremier(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void showNombresPremier(int min, int max) {
        if (min > max) {
            System.out.println("Veuillez définir un intervalle ou min < max !");
            return;
        }
        System.out.println("\nAffichage des nombres premiers entre (" + min + ", " + max + ") :");
        int count = 0,
                step = 5;
        for (int i = min; i <= max; i++) {
            if (isPremier(i)) {
                System.out.print(i + ((count % step < step - 1) ? "\t" : "\n"));
                count++;
            }
        }
        System.out.println();
    }
    
    private static int nbDigit(int nbr){
        int nb = 0;
        while(nbr/Math.pow(nbr, nb) >= 1){
            nb++;
        }
        return nb+1;
    }
    
    private static String formatInt(int val, int digit){
        String result = Integer.toString(val);
        while(result.length()<digit){
            result = " " + result;
        }
        return result;
    }

    public static void tableMultiple(int row, int col) {
        int digit = nbDigit(row*col);
        int pas = digit + 1;
        System.out.println("\nAffichage de la table multiples de (" + row + ", " + col + ") :");
        System.out.println(regle(pas * col, "+", '-', '+', "", pas));
        for (int i = 1; i <= row; i++) {
            System.out.print("|");
            for (int j = 1; j <= col; j++) {
                if (i == 1) {
                    System.out.print(formatInt(j, digit) + "|");
                } else {
                    System.out.print(formatInt(i * j, digit) + "|");
                }
            }
            System.out.println("\n"+regle(pas * col, "+", '-', '+', "", pas));
        }
    }

    public Etape3() {
//        for (int i = 0; i < 10; i++) {
//            int val = (int) (Math.random() * ((1000 - 0) + 1));
//            System.out.println("factorielle de " + val + " vaut : " + fact(val));
//        }
//        System.out.println();
//        show1D(20, 5);
//        System.out.println(regle(20, 5));
//        show2D(1, 1);
//        show2D(1, 2);
//        show2D(2, 3);
//        System.out.println("palindrome : " + isPalindrome("palindrome"));
//        System.out.println("sonos : " + isPalindrome("sonos"));
//        System.out.println("3 est premier ? : " + isPremier(3));
//        System.out.println("12 est premier ? : " + isPremier(12));
//        showNombresPremier(0, 100);
        tableMultiple(10, 10);
//        System.out.println("sonos est un palindrome ? :"+isPalindromeV3("sonos"));
//        System.out.println("palindrome est un palindrome ? :"+isPalindromeV3("palindrome"));
//        System.out.println("ressasser est un palindrome ? :"+isPalindromeV3("ressasser"));
    }

    public static void main(String[] args) {
        new Etape3();
    }

}
