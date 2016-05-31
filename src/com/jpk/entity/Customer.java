package com.jpk.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "customers")
public class Customer implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private Boolean engineering;
    private Boolean art;
    private Boolean entertainment;
    private Boolean literature;
    public int getId()
    {
        return id;
    }
    public void setId( int id )
    {
        this.id = id;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail( String email )
    {
        this.email = email;
    }
    public Boolean getEngineering()
    {
        return engineering;
    }
    public void setEngineering( Boolean engineering )
    {
        this.engineering = engineering;
    }
    public Boolean getArt()
    {
        return art;
    }
    public void setArt( Boolean art )
    {
        this.art = art;
    }
    public Boolean getEntertainment()
    {
        return entertainment;
    }
    public void setEntertainment( Boolean entertainment )
    {
        this.entertainment = entertainment;
    }
    public Boolean getLiterature()
    {
        return literature;
    }
    public void setLiterature( Boolean literature )
    {
        this.literature = literature;
    }
    public String getAge()
    {
        return age;
    }
    public void setAge( String age )
    {
        this.age = age;
    }
}
