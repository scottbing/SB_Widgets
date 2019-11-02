package com.here.android.example.sb_widgets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity
 implements AdapterView.OnItemSelectedListener {

    ViewGroup contentView;
    Spinner spinner;
    Switch contentSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentView = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);        

        spinner = new Spinner(this);
        contentView.addView(spinner);

        setupSwitch();

    }

    private void setupSwitch() {
        contentSwitch = (Switch)findViewById(R.id.switch1);
        contentSwitch.setChecked(true);
//        changeSource("colors");
        contentSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Switch sw = (Switch) compoundButton;
                if (sw.isChecked()) {
                    changeSource("colors");
                } else {
                    changeSource("planets");
                }
            }
        });
    }

    private void changeSource(String source) {
        switch(source) {
            case "colors":
                String colors[] =
                        {"Blue", "Red", "White", "Yellow", "Black", "Green", "Purple", "Orange", "Grey"};
                ArrayAdapter<String> spinnerArrayAdapter =
                        new  ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, colors);
                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(spinnerArrayAdapter);
                spinner.setOnItemSelectedListener(this);
                break;
            default: //planets chosen
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this,
                    R.array.planets_array, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(this);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
        if (contentSwitch.isChecked()) {
            Log.d("switch","colors");
            String color = (String)parent.getItemAtPosition(i);
            switch(color) {
                case "Red":
                    contentView.setBackgroundColor(Color.RED);
                    break;
                case "Blue":
                    contentView.setBackgroundColor(Color.BLUE);
                    break;
                case "White":
                    contentView.setBackgroundColor(Color.WHITE);
                    break;
                case "Yellow":
                    contentView.setBackgroundColor(Color.YELLOW);
                    break;
                case "Black":
                    contentView.setBackgroundColor(Color.BLACK);
                    break;
                case "Green":
                    contentView.setBackgroundColor(Color.GREEN);
                    break;
                case "Purple":
                    contentView.setBackgroundColor(Color.parseColor("#800080"));
                    break;
                case "Orange":
                    contentView.setBackgroundColor(Color.parseColor("#ffa500"));
                    break;
                case "Grey":
                    contentView.setBackgroundColor(Color.parseColor("#808080"));
                    break;
                default:
                    contentView.setBackgroundColor(Color.WHITE);
                    break;
            }
        } else {
            Log.d("switch", "planets");
            String planet = (String) parent.getItemAtPosition(i);
            switch (planet) {
                case "Mercury":
                    Log.d("Planets", "Mercury");
                    break;
                case "Venus":
                    Log.d("Planets", "Venus");
                    break;
                case "Earth":
                    Log.d("Planets", "Earth");
                    break;
                case "Mars":
                    Log.d("Planets", "Mars");
                    break;
                case "Jupiter":
                    Log.d("Planets", "Jupiter");
                    break;
                case "Saturn":
                    Log.d("Planets", "Saturn");
                    break;
                case "Uranus":
                    Log.d("Planets", "Uranus");
                    break;
                case "Neptune":
                    Log.d("Planets", "Neptune");
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        contentView.setBackgroundColor(Color.WHITE);
    }
}
