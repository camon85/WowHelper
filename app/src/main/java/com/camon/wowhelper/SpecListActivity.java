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

import com.camon.wowhelper.common.model.SpecModel;
import com.camon.wowhelper.common.util.DataHandler;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;


public class SpecListActivity extends ListActivity implements AdapterView.OnItemClickListener {
    private String TAG = "TalentListActivity";
    private String classId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. get passed intent
        Intent intent = getIntent();

        // 2. get person object from intent
        classId = (String) intent.getSerializableExtra("classId");
        makeList(classId);
    }

    private void makeList(String classId) {
        List<SpecModel> specList = DataHandler.getSpecList(classId);
        List<String> specs = new ArrayList<String>();

        for(SpecModel spec : specList) {
            specs.add(spec.getName());
        }

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, specs));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        String selectedItem = (String) getListView().getItemAtPosition(position);
        Intent intent = new Intent(this, TalentListActivity.class);
        intent.putExtra("classId", classId);
        intent.putExtra("talentColumn", position);
        startActivity(intent);
    }
}
