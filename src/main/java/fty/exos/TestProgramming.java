/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.exos;

/**
 * @author utilisateur
 */
public class TestProgramming {

    ProgrammingPair pair = new ProgrammingPair();
    ProgrammingPair other = pair.clone();

    public TestProgramming() {
        pair.setDriver(new Person("Clark", "Kent", 42));
        pair.setNavigator(new Person("Lex", "Luthor", 45));
    }
}
