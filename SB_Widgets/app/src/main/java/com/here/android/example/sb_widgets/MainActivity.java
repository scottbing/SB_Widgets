package com.here.android.example.sb_widgets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.Toast;

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
                    this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "You chose planet Mercury.", Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case "Venus":
                    Log.d("Planets", "Venus");
                    this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "You chose planet Venus.", Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case "Earth":
                    Log.d("Planets", "Earth");
                    this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "You chose planet Earth.", Toast.LENGTH_SHORT).show();
                        }
                    });
                    processEarth();
                    break;
                case "Mars":
                    Log.d("Planets", "Mars");
                    this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "You chose planet Mars.", Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case "Jupiter":
                    Log.d("Planets", "Jupiter");
                    this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "You chose planet Jupiter.", Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case "Saturn":
                    Log.d("Planets", "Saturn");
                    this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "You chose planet Saturn.", Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case "Uranus":
                    Log.d("Planets", "Uranus");
                    this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "You chose planet Uranus.", Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case "Neptune":
                    Log.d("Planets", "Neptune");
                    this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "You chose planet Neptune.", Toast.LENGTH_SHORT).show();
                        }
                    });
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

    private void processEarth() {
        // ask user if they would like to get their location coordinates
        // build the guts of the dialog here
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Process Earth");
        builder.setMessage("Would you like to get your geographic location coordinates?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // User has requested location coordinates
                Log.d("Location", "Yes");
                Toast toast = Toast.makeText(getApplicationContext(), "Get Location.", Toast.LENGTH_SHORT);

                // get loacation
                Intent intent = new Intent(MainActivity.this, GetLocationActivity.class);
                startActivity(intent);
                //finish();    // comment out to stay within the application

                dialog.dismiss();
            }
        });

        // show the dialog here
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("Location", "No");
                Toast toast = Toast.makeText(getApplicationContext(), "Do Nothing.", Toast.LENGTH_SHORT);
                // Do nothing
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();

    }
}
