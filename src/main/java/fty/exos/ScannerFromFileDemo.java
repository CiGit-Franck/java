/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.exos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author utilisateur
 */
public class ScannerFromFileDemo {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File("inputFile.txt"))) {
            for (int i = 0; sc.hasNextLine(); ++i) {
                System.out.println("[" + i + "]:" + sc.nextLine());
            }
            sc.close();
        }
    }
}
