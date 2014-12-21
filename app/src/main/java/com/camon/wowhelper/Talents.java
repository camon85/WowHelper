package com.camon.wowhelper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Talents {
    private JsonObject talentsData = null;

    public Talents(InputStream is) {
        String data = getStringFromInputStream(is);
        talentsData = parseData(data);
    }

    private String getStringFromInputStream(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

    private JsonObject parseData(String data) {
        JsonElement jelement = new JsonParser().parse(data);
        return jelement.getAsJsonObject();
    }

    public JsonObject getTalentsData() {
        return talentsData;
    }

    public JsonObject getTalentDataById(int id) {
        return talentsData.get(String.valueOf(id)).getAsJsonObject();
    }
}
