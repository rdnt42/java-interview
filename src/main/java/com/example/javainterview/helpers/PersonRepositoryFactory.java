package com.example.javainterview.helpers;

/**
 * Created with IntelliJ IDEA.
 * User: marowak
 * Date: 22.06.2022
 * Time: 0:18
 */
public class PersonRepositoryFactory {
    public static RepositoryPerson getPerson() {
        return new RepositoryPerson();
    }
}
