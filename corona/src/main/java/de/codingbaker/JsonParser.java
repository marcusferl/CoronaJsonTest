package de.codingbaker;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONObject;

public class JsonParser {

    

    public JsonParser() {

        
    }

    public static String readAll(Reader reader) throws IOException{
        StringBuilder sb = new StringBuilder();
        int cp;

        while((cp = reader.read()) != -1){
            sb.append((char) cp);
        }
        return sb.toString();

    }
    public static JSONObject readJsonFormUrl(String url ) throws MalformedURLException, IOException{
        InputStream is = new URL(url).openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String jsonText = readAll(br);
        JSONObject json = new JSONObject(jsonText);
        return json;
        }
}