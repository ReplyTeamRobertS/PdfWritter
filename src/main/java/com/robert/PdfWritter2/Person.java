package com.robert.PdfWritter2;


public class Person {

    private String company;
    private String contact;
    private String country;

    public Person(String company, String contact, String country) {
        this.company = company;
        this.contact = contact;
        this.country = country;
    }

    public Person(){}

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
