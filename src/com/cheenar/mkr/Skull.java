package com.cheenar.mkr;

/**
 * @author Cheenar
 * @className Skull
 * @description Main class for the Skull API
 */

public class Skull
{

    private static Skull _skull = new Skull();
    private String sessionID;
    private SkullWebsiteParser parser;
    private SkullBinaryDownloader downloader;

    public Skull()
    {
        this.sessionID = "-1";
        this.parser = new SkullWebsiteParser();
        this.downloader = new SkullBinaryDownloader();
    }

    /** Getters **/

    public static Skull getSkull()
    {
        return _skull;
    }

    public static String getAPIName()
    {
        return "skull-music";
    }

    public static String[] getContributors()
    {
        return new String[] { "cheenar" };
    }

    public String getSessionID()
    {
        return this.sessionID;
    }

    public SkullWebsiteParser getParser()
    {
        return this.parser;
    }

    public SkullBinaryDownloader getDownloader()
    {
        return this.downloader;
    }

    /** Setters **/

    public void setSessionID(String sessionID)
    {
        this.sessionID = sessionID;
    }

    /** API Functions **/

}
