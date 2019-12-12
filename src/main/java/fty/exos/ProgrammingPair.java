
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
public class ProgrammingPair {

    Person driver;
    Person navigator;

    @Override
    public String toString() {
        return "Driver : " + driver
                + "\nNavigator : " + navigator;
    }

    @Override
    public ProgrammingPair clone()  {
        return new ProgrammingPair(new Person(driver), new Person(navigator)); // this cstor should exist anyway !
    }

    public ProgrammingPair() {
    }

    public ProgrammingPair(Person driver, Person navigator) {
        this.driver = driver;
        this.navigator = navigator;
    }

    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    public Person getNavigator() {
        return navigator;
    }

    public void setNavigator(Person navigator) {
        this.navigator = navigator;
    }
}
