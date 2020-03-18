package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn1=findViewById(R.id.btn1);
        final TextView tv1=findViewById(R.id.tv1);
        final ImageView iv1=findViewById(R.id.iv1);
        final SeekBar sbar1=findViewById(R.id.sbar1);
        final Switch sw1=findViewById(R.id.sw1);
        final RadioGroup rg1=findViewById(R.id.rg1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("welcome!");
                Log.d("MainActivity","Text  change");
            }
        });

        sbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int textsize=8+28*progress/100;
                tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP,textsize);
                Log.d("MainActivity", "TextSize is "+String.valueOf(textsize)+"sp");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    iv1.setVisibility(View.VISIBLE);
                    Log.d("MainActivity","Image is visible ");
                }else{
                    iv1.setVisibility(View.INVISIBLE);
                    Log.d("MainActivity","Image is invisible ");
                }
            }
        });

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==findViewById(R.id.rb1).getId()){
                    tv1.setTextColor(Color.RED);
                    Log.d("MainActivity","Text is red");
                }else{
                    tv1.setTextColor(Color.BLACK);
                    Log.d("MainActivity","Text is black");
                }
            }
        });

    }
}
