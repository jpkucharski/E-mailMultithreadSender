package com.jpk.entity;

public enum AgeOfCustomer
{
    age16to20( "16-20" ),
    age21to25( "21-25" ),
    age26to30( "26-30" ),
    age31to35( "31-35" ),
    age36to40( "36-40" ),
    age41to45( "41-45" ),
    age46to50( "46-50" ),
    age51to55( "51-55" ),
    age56to60( "56-60" );

    private final String age;

    AgeOfCustomer( String age )
    {
        this.age = age;
    }

    public String getAge()
    {
        return age;
    }
}