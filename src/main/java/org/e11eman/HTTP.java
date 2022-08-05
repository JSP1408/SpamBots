package org.e11eman;

import java.io.*;
import java.net.*;
import java.util.*;

public class HTTP {
    public static ArrayList getHTML(String urlToRead) throws Exception {
        ArrayList result = new ArrayList();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.add(line);
            }
        }

        return result;
    }

    public static void main(ArrayList args) {
        System.out.println(args);
    }
}