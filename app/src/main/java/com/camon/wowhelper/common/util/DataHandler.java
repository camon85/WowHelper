package com.camon.wowhelper.common.util;

import com.camon.wowhelper.common.constant.ClassEnum;
import com.camon.wowhelper.common.model.SpecModel;
import com.camon.wowhelper.common.model.TalentModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    private static JsonObject talents;

    public static void init(InputStream is) {
        String jsonString = getStringFromInputStream(is);
        talents = toJsonObject(jsonString);
    }

    private static String getStringFromInputStream(InputStream is) {
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

    private static JsonObject toJsonObject(String data) {
        JsonElement jelement = new JsonParser().parse(data);
        return jelement.getAsJsonObject();
    }

    public static List<String> getClassList() {
        List<String> classList = new ArrayList<String>();

        for(ClassEnum classEnum : ClassEnum.values()) {
            String id = classEnum.getId();
            String className = talents.get(id).getAsJsonObject().get("class").getAsString();
            classList.add(className);
        }

        return classList;
    }

    public static List<SpecModel> getSpecList(String classId) {
        JsonArray specList = talents.get(classId).getAsJsonObject().get("specs").getAsJsonArray();
        Type type = new TypeToken<List<SpecModel>>(){}.getType();

        return new Gson().fromJson(specList, type);
    }

    public static List<TalentModel> getTalentList(String classId, int talentColumn) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<TalentModel>>(){}.getType();
        List<TalentModel> talentList = new ArrayList<TalentModel>();
        JsonArray talentArray = talents.get(classId).getAsJsonObject().get("talents").getAsJsonArray();

        // TODO
        for (JsonElement talentEl : talentArray) {
            JsonArray tierArray = talentEl.getAsJsonArray();
            List<TalentModel> tierList = gson.fromJson(tierArray, type);
            talentList.addAll(tierList);
        }

        return talentList;
    }
}
