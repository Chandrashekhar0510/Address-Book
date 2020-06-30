package com.addressBook.test;

import com.addressBook.model.Person;
import com.addressBook.model.PersonAddress;
import com.addressBook.model.Services;

import java.util.*;
import java.io.*;

public class AddressBookManager
{
        static Scanner userScanner = new Scanner(System.in);
        File file = null;
        FileOutputStream outputStream = null;
        FileInputStream inputStream = null;
        ObjectOutputStream objOutStrm = null;
        ObjectInputStream objInStrm = null;
        Services currentAddressBook = null;

	public  Services getcurrentAddressBook()
        {
                return this.currentAddressBook;
        }

        public void newAddressBook(String addressBookName) throws IOException
        {
                currentAddressBook = new Services(addressBookName);
                file = new File("./" + addressBookName);
                System.out.println(addressBookName +":New File created successfully");
        }

	public void openAddressBook(String addressBookName) throws Exception
        {
                currentAddressBook =  new Services(addressBookName);
                file = new File("./"+ addressBookName);
                inputStream = new FileInputStream(addressBookName);
                objInStrm = new ObjectInputStream(inputStream);
                boolean count = true;
                while(count)
                {
                        if(inputStream.available()!=0)
                        {
                                Person per  = (Person) objInStrm.readObject();
                                currentAddressBook.addPerson(per);
                        }
                        else
                        {
                                count=false;
                        }
                }
                System.out.println(addressBookName +": File Opened successfully");
        }

	public static int fileMenu()
        {
                System.out.println("************File Menu*******************");
                System.out.println("1.Create New Address Book");
                System.out.println("2. Open Address Book");
                System.out.println("3. Save Address Book");
                System.out.println("4.Exit");
                System.out.println("*************************************");
                System.out.println();
                System.out.println("Enter your choice");
                int fileMenuChoice =  userScanner.nextInt();
                return fileMenuChoice;
        }

	public static int crudMenu()
        {
                System.out.println("============================Address Book Menu======================");
                System.out.println("1. Add Person");
                System.out.println("2. Edit Person");
                System.out.println("3. Delete Person");
                System.out.println("4.Sort By First Name");
                System.out.println("5.Sort By Last Name");
                System.out.println("6. Sort By Zip Code");
                System.out.println("7. Print all enteries");
                System.out.println("8. Exit to file Menu");
                System.out.println("===================================================================");
                System.out.println();
                System.out.println("Enter your choice");
                int crudMenuChoice = userScanner.nextInt();
                return crudMenuChoice;

        }

	public static void main(String args[]) throws IOException, ClassNotFoundException	 
        {

                try
                {
                        AddressBookManager myManager = new AddressBookManager();
                        String inputAddressBookName = null;
                        while(true)
                        {
                                int fileMenuOption = fileMenu();
                                outerloop:
                                switch(fileMenuOption)
                                {
                                        case 1 :
                                                        System.out.println("Enter First Name:");
                                                        inputAddressBookName = userScanner.next();
                                                        myManager.newAddressBook(inputAddressBookName);
                                                        innerloop:
                                                        while(true)
                                                        {
                                                                int crudMenuOption = crudMenu();
                                                                switch(crudMenuOption)
                                                                {
                                                                        case 1 : myManager.getcurrentAddressBook().addPerson(null);
                                                                        break;
                                                                        case 2 : myManager.getcurrentAddressBook().editPerson(null);
                                                                        break;
                                                                        case 3 : myManager.getcurrentAddressBook().deletePerson(null);
                                                                        break;
                                                                        case 4 : myManager.getcurrentAddressBook().sortByFirstName();
                                                                        break;
                                                                        case 5 : myManager.getcurrentAddressBook().sortByLastName();
                                                                        break;
                                                                       // case 6 : myManager.getcurrentAddressBook().sortByZipCode();
                                                                        //break;
                                                                        case 7 :  myManager.getcurrentAddressBook().printAddressBookList();
                                                                        break;
                                                                        case 8 :
                                                                        break outerloop;


                                                                }

                                                        }
                                }
                        }

                }

	 catch(IOException ex)
                {
                        System.out.println(ex);
                }
        }

}

