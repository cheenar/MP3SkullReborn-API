package com.cheenar.mkr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * @author Cheenar
 * @className SkullWebsiteParser
 * @description Website parsing that will grab the music
 */
public class SkullWebsiteParser
{

    /**
     * @name query
     * @param queryString this is the string to query for (e.g. taylor swift)
     * @description this will return an arraylist of the query links
     * @throws Exception
     */
    public ArrayList<String> query(String queryString) throws Exception
    {
        if(Skull.getSkull().getSessionID().equals("-1"))
        {
            throw new Exception("Invalid session id, please set the session id");
        }
        try
        {
            String[] queryArgs = queryString.split(" ");
            StringBuilder query = new StringBuilder();
            query.append("https://mp3skullreborn.com/search_db.php?q=");
            for(int i = 0; i < queryArgs.length; i++)
            {
                query.append(queryArgs[i]);
                if(i == queryArgs.length - 1)
                {
                    break;
                }
                query.append("+");
            }
            query.append("&fckh=");
            query.append(Skull.getSkull().getSessionID());
            URL url = new URL(query.toString());
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            ArrayList<String> links = new ArrayList<String>();
            while((line = in.readLine()) != null)
            {
                if(line.contains("rel=\"nofollow\" target=\"_blank\">Download</a>"))
                {
                    String lineArgs[] = line.split("\"");
                    String link = lineArgs[5];
                    System.out.println("[Query] " + link);
                    links.add(link);
                }
            }
            in.close();
            return links;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
