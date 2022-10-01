package com.bridgelabz.addressbookmanagementsystem;

import java.util.List;

import com.bridgelabz.com.bridgelabz.addressbookmanagementsystem.Address;
import com.bridgelabz.com.bridgelabz.addressbookmanagementsystem.AddressBook;
import com.bridgelabz.com.bridgelabz.addressbookmanagementsystem.AddressBookFileIO;
import com.bridgelabz.com.bridgelabz.addressbookmanagementsystem.ContactPerson;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddressBookTest {
    static AddressBook addressBook = new AddressBook();

    @BeforeClass
    public static void createAddressBookObject() {
        addressBook.setAddressBookName("book1");
    }

    @Test
    public void givenDetails_ShouldAddToContactList() {

        ContactPerson person = new ContactPerson();
        Address address = new Address();

        String firstName = "Dipesh";
        String lastName = "Rathod";
        String email = "dipesh@gmail.com";
        long phoneNumber = 938476387;
        String city = "Thane";
        String state = "Maharashtra";
        long zipCode = 421503;
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);
        person.setPhoneNumber(phoneNumber);
        address.setCity(city);
        address.setState(state);
        address.setZip(zipCode);
        person.setAddress(address);

        addressBook.addContact(firstName, person);

        firstName = "Shubham";
        lastName = "Patil";
        email = "shubham@gmail.com";
        phoneNumber = 797648253;
        city = "Mangalore";
        state = "Karnataka";
        zipCode = 560043;
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);
        person.setPhoneNumber(phoneNumber);
        address.setCity(city);
        address.setState(state);
        address.setZip(zipCode);
        person.setAddress(address);

        addressBook.addContact(firstName, person);

        int listSize = addressBook.contactList.size();
        Assert.assertEquals(2, listSize);

    }

    @Test
    public void given2Contacts_WhenWrittenToFile_ShouldMatchEntries()
    {
        AddressBookFileIO addressFileIO = new AddressBookFileIO();
        addressFileIO.writeToAddressBookFile("book1.txt", addressBook.contactList);
        addressFileIO.printData("book1.txt");
        long entries = addressFileIO.countEntries("book1.txt");
        Assert.assertEquals(2, entries);

    }

    @Test
    public void givenFile_WhenRead_ShouldReturnNumberOfEntries() {

        AddressBookFileIO addressFileIO = new AddressBookFileIO();
        List<String> entries = addressFileIO.readDataFromFile("book1.txt");
        long countEntries = entries.size();
        Assert.assertEquals(2, countEntries);
    }
}
