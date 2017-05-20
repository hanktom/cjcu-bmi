package com.tom.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void bmi(View view){
        Log.d("HAHA", "bmi");
        EditText edWeight = (EditText) findViewById(R.id.ed_weight);
        EditText edHeight = (EditText) findViewById(R.id.ed_height);
        String sWeight = edWeight.getText().toString();
        String sHeight = edHeight.getText().toString();
        float height = Float.parseFloat(sHeight);
        float weight = Float.parseFloat(sWeight);
        float bmi = weight/(height*height);
        Log.d("HAHA", "bmi:"+bmi);
    }
}
