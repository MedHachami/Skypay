package com.skypay.bank2kata;
import com.skypay.bank2kata.service.Account;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Account acc = new Account();
        acc.printStatement();
        System.out.println( "Hello World!!!" );
    }
}
