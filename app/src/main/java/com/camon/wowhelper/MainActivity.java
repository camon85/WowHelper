package com.camon.wowhelper;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private Button btnSkill;
    private Button btnDiminishingReturns;
    private Button btnBattleBet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSkill = (Button) findViewById(R.id.btn_skill);
        btnDiminishingReturns = (Button) findViewById(R.id.btn_diminishing_returns);
        btnBattleBet = (Button) findViewById(R.id.btn_battle_net);

        btnSkill.setOnClickListener(this);
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

        if (R.id.btn_diminishing_returns == id) {
            Intent intent = new Intent(this, ClassListActivity.class);
            startActivity(intent);
        }
    }
}
