package com.camon.wowhelper;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.camon.wowhelper.common.model.SpecModel;
import com.camon.wowhelper.common.model.SpellModel;
import com.camon.wowhelper.common.model.TalentModel;
import com.camon.wowhelper.common.util.DataHandler;
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
        String classId = (String) intent.getSerializableExtra("classId");
        int talentColumn = (int) intent.getSerializableExtra("talentColumn");
        makeList(classId, talentColumn);
    }

    private void makeList(String classId, int talentColumn) {
        List<TalentModel> talentList = DataHandler.getTalentList(classId, talentColumn);
        List<String> talents = new ArrayList<String>();

        for (TalentModel talent : talentList) {
            SpellModel spell = talent.getSpell();
            String rowData =
            "[tire/column]" + talent.getTier() + "/" + talent.getColumn() + "\n" +
            "[스킬명]" + spell.getName() + "\n" +
            "[설명]" + spell.getDescription() + "\n" +
            "[시전시간]" + spell.getCastTime() + "\n" +
            "[쿨다운]" + spell.getCooldown();
            talents.add(rowData);
        }

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, talents));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }
}
