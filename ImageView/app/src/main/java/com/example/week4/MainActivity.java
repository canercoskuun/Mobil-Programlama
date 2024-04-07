package com.example.week4;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.week4.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<String>gunler;
    private static final String LOG_TAG="MAİN_ACTİVİTY_LOG";
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gunler = new ArrayList<>();

        gunler.add("kedi");
        gunler.add("kedi2");
        gunler.add("kedi3");
        gunler.add("kedi4");


        ArrayAdapter<String>dataAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,gunler);
        binding.spinner2.setAdapter(dataAdapter);
        binding.spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              if(i==0){
              binding.imageView2.setImageResource(R.drawable.kedi);
               }
                if(i==1){
                 binding.imageView2.setImageResource(R.drawable.kedi2);
                 }
                  if(i==2){
                 binding.imageView2.setImageResource(R.drawable.kedi3);
                 }
                 if(i==3){
                   binding.imageView2.setImageResource(R.drawable.kedi4);
                   }
                  }
                   @Override
                  public void onNothingSelected(AdapterView<?> adapterView) {

                                                       }
                  });
//Glide.with(this).load("https://www.petmd.com/sites/default/files/Acute-Dog-Diarrhea-47066074.jpg").into(binding.imageView2);
                //      Log.d(LOG_TAG, "onCreate: ");


    }

    public void Clicked(View view) {
        if(binding.radioButton.isChecked()){
            binding.imageView2.setImageResource(R.drawable.kedi);
        }
        if(binding.radioButton2.isChecked()){
            binding.imageView2.setImageResource(R.drawable.kedi2);
        }
        if(binding.radioButton3.isChecked()){
            binding.imageView2.setImageResource(R.drawable.kedi3);
        }
        if(binding.radioButton4.isChecked()){
            binding.imageView2.setImageResource(R.drawable.kedi4);
        }
    }
}