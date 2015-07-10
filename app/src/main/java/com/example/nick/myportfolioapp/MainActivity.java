package com.example.nick.myportfolioapp;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<View> allButtons;
        allButtons = ((RelativeLayout) findViewById(R.id.container)).getTouchables();
        PorterDuffColorFilter orangeFilter = new PorterDuffColorFilter(Color.rgb(240,140,53), PorterDuff.Mode.SRC_ATOP);
        PorterDuffColorFilter redFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        for(View b : allButtons) {
            b.setOnClickListener(this);

            b.getBackground().setColorFilter(orangeFilter);
        }
        allButtons.get(allButtons.size() - 1).getBackground().setColorFilter(redFilter);
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
        String toastMessage;

        if (!(v instanceof Button)) {
            toastMessage = getResources().getString(R.string.not_button);
        } else {
            Button clickedButton = (Button)v;
            toastMessage = clickedButton.getText().toString();
        }

        Toast.makeText(getApplicationContext(), "This button will launch " + toastMessage + "!",
                Toast.LENGTH_SHORT).show();
    }
}
