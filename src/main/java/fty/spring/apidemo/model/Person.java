package fty.spring.apidemo.model;

import java.time.LocalDate;

/**
 *
 * @author utilisateur
 */
public class Person {
    
    private String firstName;
    private String lastName;
    private String numSS;
    private LocalDate birthDate;

    public Person(String firstName, String lastName, String numSS, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numSS = numSS;
        this.birthDate = birthDate;
    }

    public Person(String firstName, String lastName) {
        this(firstName, lastName, "", LocalDate.now());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumSS() {
        return numSS;
    }

    public void setNumSS(String numSS) {
        this.numSS = numSS;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", numSS=" + numSS + ", birthDate=" + birthDate + '}';
    }
    
}
