package com.coforge.AdminService.Entity;



import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name="customer_details")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    int  customerNumber;

    String firstName;
    String middleName;
    String lastName;
    String city;
    String contactNumber;
    String occupation;
    Date dateOfBirth;


    public Customer(String firstName, String middleName, String lastName, String city, String contactNumber, String occupation, Date dateOfBirth) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.city = city;
        this.contactNumber = contactNumber;
        this.occupation = occupation;
        this.dateOfBirth = dateOfBirth;
    }

    public Customer() {
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
