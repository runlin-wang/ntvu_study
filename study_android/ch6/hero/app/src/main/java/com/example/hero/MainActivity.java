package com.example.hero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] hero_name = {"毛泽东", "马云", "曹操", "yourself"};  //TODO
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = this.findViewById(R.id.spinner);
        //TODO
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, hero_name);
        spinner.setAdapter(adapter);  //TODO
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //TODO
                Toast.makeText(MainActivity.this, "你选择了：" + hero_name[position], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
