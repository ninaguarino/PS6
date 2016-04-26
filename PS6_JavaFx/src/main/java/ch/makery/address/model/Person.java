package ch.makery.address.model;

import java.time.LocalDate;


import domain.PersonDomainModel;

public class Person extends PersonDomainModel {

    public Person() {
        this(null, null, null, (Integer) null, null, null);
    }

    public Person(String firstName, String lastName, String street, int postalCode, String city, Object birthday ) {
        this.setFirstName(firstName);
        this.setLastName(lastName);

        // Some initial dummy data, just for convenient testing.
        this.setStreet(street);
        this.setPostalCode(postalCode);
        this.setCity(city);
        this.setBirthday((LocalDate.of(1999, 2, 21)));
    }

}