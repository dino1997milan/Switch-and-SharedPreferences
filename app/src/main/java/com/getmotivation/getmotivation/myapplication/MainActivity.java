package com.getmotivation.getmotivation.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch sw1,sw2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sw1 = findViewById(R.id.switch1);
        sw2 = findViewById(R.id.switch2);

        SharedPreferences sharedPreferences =getSharedPreferences("save",MODE_PRIVATE);
        sw1.setChecked(sharedPreferences.getBoolean("value1",false));
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true){
                    Toast.makeText(getApplicationContext(), "sw1 selezionato!", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value1", true);
                    editor.apply();
                }
                else{Toast.makeText(getApplicationContext(), "Hai deselezionato sw1" + " !", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value1",false);
                    editor.apply();
                }
            }
        });

        sw2.setChecked(sharedPreferences.getBoolean("value2",false));
        sw2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true){
                    Toast.makeText(getApplicationContext(), "sw2 selezionato!", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value2", true);
                    editor.apply();
                }
                else{Toast.makeText(getApplicationContext(), "Hai deselezionato sw2" + " !", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value2",false);
                    editor.apply();
                }
            }
        });
    }
}