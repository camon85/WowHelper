package com.camon.wowhelper;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.camon.wowhelper.common.util.DataHandler;

import java.util.List;


public class ClassListActivity extends ListActivity implements AdapterView.OnItemClickListener {
    private String TAG = "ClassListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeList();
    }

    private void makeList() {
        List<String> classList = DataHandler.getClassList();
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classList));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int classId = position + 1;
        String selectedItem = (String) getListView().getItemAtPosition(position);
        Intent intent = new Intent(this, SpecListActivity.class);
        intent.putExtra("classId", String.valueOf(classId));
        startActivity(intent);
    }

}
