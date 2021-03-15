package com.company;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

public class CivicInfo {
    String data = "";

    public CivicInfo() throws Exception {
        readUrl("https://www.googleapis.com/civicinfo/v2/elections?key=AIzaSyCZIKr_7NQVp1vh4025d4hBkiV41IBlJyo");
    }

    private void readUrl(String urlStr) throws Exception {
        JSONParser parser = new JSONParser();

        //read url
        URL url = new URL(urlStr); // URL to Parse
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

        Object o = parser.parse(in);
        JSONArray a = new JSONArray();
        a.add(o);

        JSONObject elections = (JSONObject) a.get(0);

        // Loop through each item
        for(Iterator iterator = elections.keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            if(key.equals("elections")){
                for(Object election : (JSONArray) elections.get(key)) {
                    JSONObject e = (JSONObject) election;
                    data += e.get("name") + " : " + e.get("electionDay") + "\n";
                }
            }
        }
        in.close();
    }

    public String getInfo(){
        return data;
    }
}
