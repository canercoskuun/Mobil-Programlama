package com.example.week5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.week5.databinding.ActivityMain2Binding;
import com.example.week5.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {
    public static final String mySharedPreferenceName="myPref";
    Integer red=0;
    Integer green=0;
    Integer blue=0;
    private ActivityMain2Binding binding;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sharedPreferences=getSharedPreferences(mySharedPreferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();

        red = sharedPreferences.getInt("red",74);
        green = sharedPreferences.getInt("green",154);
        blue = sharedPreferences.getInt("blue",172);
        binding.seekBar.setProgress(red);
        binding.seekBar2.setProgress(green);
        binding.seekBar3.setProgress(blue);
        binding.textView2.setText("R: "+red+" G: "+green+" B: "+blue);
        int color= Color.rgb(red,green,blue);
        binding.main.setBackgroundColor(color);
   binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
       @Override
       public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
           red=i;
           binding.textView2.setText("R: "+red+" G: "+green+" B: "+blue);
           int color= Color.rgb(red,green,blue);
           binding.main.setBackgroundColor(color);
           editor.putInt("red",red);
           editor.apply();
       }

       @Override
       public void onStartTrackingTouch(SeekBar seekBar) {

       }

       @Override
       public void onStopTrackingTouch(SeekBar seekBar) {

       }
   });
   binding.seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
       @Override
       public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
           green=i;
           binding.textView2.setText("R: "+red+" G: "+green+" B: "+blue);
           int color= Color.rgb(red,green,blue);
           binding.main.setBackgroundColor(color);
           editor.putInt("green",green);
           editor.apply();
       }

       @Override
       public void onStartTrackingTouch(SeekBar seekBar) {

       }

       @Override
       public void onStopTrackingTouch(SeekBar seekBar) {

       }
   });


   binding.seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
       @Override
       public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
              blue=i;
           binding.textView2.setText("R: "+red+" G: "+green+" B: "+blue);
           int color= Color.rgb(red,green,blue);
           binding.main.setBackgroundColor(color);
           editor.putInt("blue",blue);
           editor.apply();
       }

       @Override
       public void onStartTrackingTouch(SeekBar seekBar) {

       }

       @Override
       public void onStopTrackingTouch(SeekBar seekBar) {

       }
   });





        editor.apply();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}