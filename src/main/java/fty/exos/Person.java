/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.exos;

import java.util.TreeSet;

/**
 *
 * @author utilisateur
 */
public class Person implements Comparable {

    private String firstname;
    private String lastname;
    private int age;

    /**
     * Copie superficielle
     *
     * @param firstname
     * @param lastname
     * @param age
     */
    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    /**
     * Copie profonde
     *
     * @param aCopy
     */
    public Person(Person aCopy) {
        this.firstname = aCopy.firstname;
        this.lastname = aCopy.lastname;
        this.age = aCopy.age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public boolean equals(Person other) {
//        return firstname.equals(other.firstname)
//                && lastname.equals(other.lastname)
//                && (age == other.age);
//    }

    @Override
    public boolean equals(Object other) {
        if (other != null && (other instanceof Person)) {
            Person otherPerson = (Person) other;
            if (firstname.equals(otherPerson.firstname)
                    && lastname.equals(otherPerson.lastname)
                    && (age == otherPerson.age)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + (int) (age ^ (age >>> 32));
        return result;
    }

    @Override
    public int compareTo(Object o) {
        return this.firstname.compareTo(((Person)o).firstname)
                + this.lastname.compareTo(((Person)o).lastname);
    }
    
    @Override
    public String toString(){
        return this.firstname+" "+this.lastname+" ("+this.age+")";
    }

    public static void main(String[] args) {
        Object p1 = new Person("Franck ", "THERY", 50);
        Object p2 = new Person("Franck ", "THERY", 50);
        System.out.println(p1.equals(p2));
        TreeSet<Person> group = new TreeSet<Person>();
        group.add(new Person("Franck ", "THERY", 50));
        group.add(new Person("Bernard", "H.", 30));
        System.out.println(group);
    }
}
