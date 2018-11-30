package it.univaq.rtv.Utility;

import java.net.URL;
import java.net.URLConnection;

public class Connection {
    private static boolean connect;

    /**
     * @return
     */
    public static boolean checkConnection()
    {
        try {
            URL url = new URL("https://www.geeksforgeeks.org/");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Connection Successful");
            connect=true;
        }
        catch (Exception e) {
            System.out.println("Internet Not Connected");
            connect=false;
        }
        System.out.println(connect);
        return connect;
    }


}
