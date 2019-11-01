package com.here.android.example.sb_widgets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
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

        contentView = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);        Spinner spinner = new Spinner(this);

        spinner = new Spinner(this);
        contentView.addView(spinner);

        setupSwitch();

    }

    private void setupSwitch() {
        contentSwitch = (Switch)findViewById(R.id.switch1);
        contentSwitch.setChecked(true);
        changeSource("colors");
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
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
        String color = (String)parent.getItemAtPosition(i);
        switch(color) {
            case "Red":
                contentView.setBackgroundColor(Color.RED);
                break;
            default:
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        contentView.setBackgroundColor(Color.WHITE);
    }
}
