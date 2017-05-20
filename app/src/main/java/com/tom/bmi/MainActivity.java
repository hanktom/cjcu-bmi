package com.tom.bmi;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edWeight;
    private EditText edHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        float w = getSharedPreferences("aaa",MODE_PRIVATE)
              .getFloat("weight", 0);
        edWeight.setText((w==0)? "":String.valueOf(w));
    }

    private void findViews() {
        edWeight = (EditText) findViewById(R.id.ed_weight);
        edHeight = (EditText) findViewById(R.id.ed_height);
    }

    public void bmi(View view){
        Log.d("HAHA", "bmi");
        String sWeight = edWeight.getText().toString();
        String sHeight = edHeight.getText().toString();
        float height = Float.parseFloat(sHeight);
        float weight = Float.parseFloat(sWeight);
        float bmi = weight/(height*height);
        Log.d("HAHA", "bmi:"+bmi);
//        SharedPreferences sp = getSharedPreferences("aaa", MODE_PRIVATE);
        getSharedPreferences("aaa", MODE_PRIVATE).edit()
                .putFloat("weight", weight)
                .putFloat("height", height)
                .apply();
        new AlertDialog.Builder(this)
                .setTitle("BMI")
                .setMessage("Your BMI is :"+bmi)
                .setPositiveButton("OK", null)
                .show();
    }
}
