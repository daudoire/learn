package com.daudoire;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void concatenate()
    {
        String username = "user1";
        String password = "password1";
        String result = App.concatenate(username, password);
        assertTrue( result.equals("user1:password1") );
    }
}
