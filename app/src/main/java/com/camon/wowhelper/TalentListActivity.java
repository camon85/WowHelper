package com.camon.wowhelper;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.camon.wowhelper.common.Constant;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;


public class TalentListActivity extends ListActivity implements AdapterView.OnItemClickListener  {
    private String TAG = "TalentListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

// 1. get passed intent
        Intent intent = getIntent();

        // 2. get person object from intent
        String talents = (String) intent.getSerializableExtra("talents");
        makeList(talents);
        Log.d(TAG, talents);
    }

    private void makeList(String talents) {
        JsonElement jelement = new JsonParser().parse(talents);
        JsonObject jobj = jelement.getAsJsonObject();
        jobj.get("talents").getAsJsonArray();


        // 북마크 리스트에 아이템을 추가
        List<String> items = new ArrayList<String>();
        items.add("특성1");
        items.add("특성2");
        items.add("특성3");


        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int talentId = position + 1;

        String selectedItem = (String) getListView().getItemAtPosition(position);
        Toast.makeText(this, "[" + talentId + "] " + selectedItem, Toast.LENGTH_SHORT).show();
    }
}
