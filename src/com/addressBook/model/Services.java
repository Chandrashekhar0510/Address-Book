package com.addressBook.model;

import com.addressBook.model.PersonAddress;
import java.util.*;
import java.lang.Comparable;
import java.io.Serializable;

public class Services implements Serializable
{
        private static final long serialVersionUID = 1L;
        private String addressBookName;

        List<Person> personList = new ArrayList<Person>();
        Scanner sc = new Scanner(System.in);

		PersonAddress newAdd = new PersonAddress();

	public Services(String addressBookName)
        {
                this.addressBookName=addressBookName;
        }

        public List<Person> getPersonList()
        {
                return this.personList;
        }

        public void addPerson(Person newPer)
        {
                if(newPer==null)
                {
                        newPer=new Person();
						//PersonAddress newAdd = new PersonAddress();
                        //newPer.setAddress(new PersonAddress());

                        System.out.print("FirstName:");
                        newPer.setFirstName(sc.next());

                        System.out.print("LastName:");
                        newPer.setLastName(sc.next());

                        /*System.out.print("Address Line1 :");
                        newPer.getAddress().setAddressLine1(sc.next());

                        System.out.print("Address Line2 :");
                        newPer.getAddress().setAddressLine2(sc.next());

                        */System.out.print("City:");
                        newAdd.getCity();//.setCity(sc.next());

                        System.out.print("State:");
                        newAdd.getState();//Address().setState(sc.next());

                        System.out.print("Zip:");
                        newAdd.getZip();//Address().setZip(sc.nextLong());
			
			 System.out.print("Phone Number:");
                        newPer.setPhoneNumber(sc.next());

                }
                this.personList.add(newPer);
        }


        public void editPerson(Person editPer)
        {
                System.out.println("Enter the first name of person to edit :");
                String fName = sc.next();
                editPer = this.getPersonFromList(fName);
                if(editPer!=null)
                {
                        /*System.out.println("New Address Line1");
                        editPer.getAddress().setAddressLine1(sc.next());

                        System.out.println("New Address Line2");
                        editPer.getAddress().setAddressLine2(sc.next());

                        */System.out.println("New City");
                        newAdd.setCity(sc.next());

                        System.out.println("New State");
                        newAdd.setState(sc.next());

                        System.out.println("New Zip");
                        newAdd.setZip(sc.nextInt());

                        System.out.println("New Phone Number");
                        editPer.setPhoneNumber(sc.next());

                        System.out.println("Update Successfully!!");
                        return;

                }
                System.out.println("Person does not exists...");
        }

	 public void deletePerson(Person editPer)
        {
                System.out.println("Enter the first name of person to delete :");
                String fName = sc.next();
                editPer = this.getPersonFromList(fName);
                if(editPer!=null)
                {
                        this.personList.remove(editPer);
                                System.out.println("Deleted Successfully");
                                return;

                }
                System.out.println("Person does not exists...");


        }


        public void sortByFirstName()
        {
                this.personList.sort(Comparator.comparing(e -> e.getFirstName().toLowerCase()));
        }

         public void sortByLastName()
        {
                this.personList.sort(Comparator.comparing(e -> e.getLastName().toLowerCase()));
        }

        /*public void sortByZipCode()
        {
                Collections.sort(this.personList);
        }*/

        public Person getPersonFromList(String name)
        {
                for(Person per : this.personList)
                {
                        if(name.equalsIgnoreCase(per.getFirstName()))
                        {
                                return per;
                        }
                }
                return null;
        }

	 public void printAddressBookList()
        {
                System.out.println("========================================");
                for(Person per : this.personList)
                {
                        System.out.println(per.toString());
                }
                return;
        }
}