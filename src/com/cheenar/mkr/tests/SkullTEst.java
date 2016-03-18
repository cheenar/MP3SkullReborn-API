package com.cheenar.mkr.tests;

import com.cheenar.mkr.Skull;

/**
 * @author Cheenar
 * @className SkullTest
 * @description Will test the various API functions
 */

public class SkullTest
{

    public static void main(String[] args) throws Exception
    {
        Skull skull = Skull.getSkull();
        skull.setSessionID(args[0]);
        skull.getParser().query("taylor swift");
    }

}