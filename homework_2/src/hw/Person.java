package hw;

import java.util.List;

public class Person {
    private String name;
    private String surname;
    private List<String> phones;
    private List<String> sites;
    private Address address;

    public Person(String name, String surname, List<String> phones, List<String> sites, Address address) {
        this.name = name;
        this.surname = surname;
        this.phones = phones;
        this.sites = sites;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setSites(List<String> sites) {
        this.sites = sites;
    }

    public List<String> getSites() {
        return sites;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public String toString() {
        return name + " " + surname + System.lineSeparator()
                + "Phones: " + phones + System.lineSeparator()
                + "Sites: " + sites + System.lineSeparator() + address;
    }
}
