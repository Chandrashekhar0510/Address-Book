package com.addressBook.model;

import java.io.Serializable;

public class PersonAddress implements Serializable
{
        private static final long serialVersionUID = 1L;
       
        private String city;
        private String  state;
        private long zip;
        PersonAddress(){}
        PersonAddress(String city, String  state, long zip)
        {
                this.city = city;
                this.state = state;
                this.zip = zip;

        }

        public String getCity()
        {
                return this.city;
        }

        public void setCity(String city)
        {
                this.city = city;
        }
	public String getState()
        {
                return this.state;
        }

        public void setState(String  state)
        {
                this.state = state;
        }

        public long getZip()
        {
                return this.zip;
        }

        public void setZip(long zip)
        {
                this.zip = zip;
        }

        public String toString()
        {
                return this.city +"\n"+ this.state +"\n"+ this.zip;
        }


}
