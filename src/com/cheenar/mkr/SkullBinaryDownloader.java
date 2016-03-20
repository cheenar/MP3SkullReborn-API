package com.cheenar.mkr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by admin on 3/17/16.
 */
public class SkullBinaryDownloader
{

    public void downloadFile(String loc, String name) throws Exception
    {
        try
        {
            URL url = new URL(loc);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setRequestProperty("Content-Language", "en-US");
            http.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            http.setUseCaches(false);
            http.setDoInput(true);
            http.setDoOutput(true);
            InputStream in = http.getInputStream();
            byte[] buffer = new byte[1024];
            int n = -1;
            File file = new File(name);
            if(!file.exists())
                file.createNewFile();
            OutputStream out = new FileOutputStream(file);
            while((n = in.read(buffer)) != -1)
            {
                out.write(buffer, 0, n);
            }
            out.close();
            in.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
