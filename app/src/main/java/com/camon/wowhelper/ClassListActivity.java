package com.camon.wowhelper;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.camon.wowhelper.common.Constant;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ClassListActivity extends ListActivity implements AdapterView.OnItemClickListener {
    private String TAG = "ClassListActivity";
    private Talents talents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "=========ClassListActivity========");
        super.onCreate(savedInstanceState);
        getJsonData();
        makeList();
    }

    private void makeList() {
        // 북마크 리스트에 아이템을 추가
        List<String> items = new ArrayList<String>();

        for(Constant classEnum : Constant.values()) {
            items.add(classEnum.getName());
        }

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);
    }

    private void getJsonData() {
        AssetManager manager = getAssets();
        InputStream is = null;
        try {
            is = manager.open("data/talents.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        talents = new Talents(is);
        JsonObject talentsData = talents.getTalentsData();
        JsonObject warrior = talentsData.get("1").getAsJsonObject();
        JsonObject mage = talentsData.get("8").getAsJsonObject();
        Log.d(TAG, warrior.toString());
        Log.d(TAG, mage.toString());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int classId = position + 1;

        String selectedItem = (String) getListView().getItemAtPosition(position);
        Toast.makeText(this, "[" + classId + "] " + selectedItem, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SpecListActivity.class);
        intent.putExtra("talents", String.valueOf(talents.getTalentDataById(classId)).toString());
        startActivity(intent);
    }

}
