package com.cheenar.mkr.tests;

import com.cheenar.mkr.Skull;
import com.cheenar.mkr.SkullBinaryDownloader;

import java.util.ArrayList;

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

        SkullBinaryDownloader downloader = new SkullBinaryDownloader();
        try
        {
            ArrayList<String> links = skull.getParser().query("taylor swift");

            downloader.downloadFile(links.get(2), "TaylorSwift_22.mp3");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}