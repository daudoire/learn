package com.daudoire;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //trigger a vulnerability by hardcoding credentials

        String username = "user1";
        String password = "password1";

        System.out.println( "Hello "+username+"!\n Your password is "+password+"." );
    }
}
