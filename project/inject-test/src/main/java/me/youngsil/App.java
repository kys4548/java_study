package me.youngsil;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AccountService accountService = ContainerService.getObject(AccountService.class);
        accountService.join();

    }
}
