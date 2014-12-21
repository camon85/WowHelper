package com.camon.wowhelper;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.camon.wowhelper.common.util.DataHandler;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private String TAG = "MainActivity";
    private Button btnSkill;
    private Button btnTalent;
    private Button btnDiminishingReturns;
    private Button btnBattleBet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButtons();
        DataHandler.init(loadTalents());
    }

    private InputStream loadTalents() {
        AssetManager manager = getAssets();
        InputStream is = null;

        try {
            is = manager.open("data/talents.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return is;
    }

    private void initButtons() {
        btnSkill = (Button) findViewById(R.id.btn_skill);
        btnTalent = (Button) findViewById(R.id.btn_talent);
        btnDiminishingReturns = (Button) findViewById(R.id.btn_diminishing_returns);
        btnBattleBet = (Button) findViewById(R.id.btn_battle_net);

        btnSkill.setOnClickListener(this);
        btnTalent.setOnClickListener(this);
        btnDiminishingReturns.setOnClickListener(this);
        btnBattleBet.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (R.id.btn_skill == id) {
            Intent intent = new Intent(this, ClassListActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "준비중", Toast.LENGTH_SHORT).show();
        }
    }
}
