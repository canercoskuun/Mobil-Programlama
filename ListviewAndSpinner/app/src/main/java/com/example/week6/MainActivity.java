package com.example.week6;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.week6.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> bölgeler;
    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> spinnerAdapter;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bölgeler = new ArrayList<>();
        bölgeler.add("Marmara");
        bölgeler.add("Ege");
        bölgeler.add("Akdeniz");
        spinnerAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bölgeler);
        binding.spinner.setAdapter(spinnerAdapter);
        ArrayList<String> marmara = new ArrayList<>();
        ArrayList<String> ege = new ArrayList<>();
        ArrayList<String> akdeniz = new ArrayList<>();
        marmara.add("İstanbul");
        marmara.add("Kocaeli");
        marmara.add("Bursa");
        ege.add("İzmir");
        ege.add("Aydın");
        ege.add("Muğla");
        akdeniz.add("Antalya");
        akdeniz.add("Mersin");
        akdeniz.add("Adana");

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, marmara);
                    binding.listWiew.setAdapter(arrayAdapter);
                    binding.button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            marmara.add(binding.editTextText.getText().toString());
                            arrayAdapter.notifyDataSetChanged();
                        }
                    });


                }
                if(i==1){
                    arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,ege);
                    binding.listWiew.setAdapter(arrayAdapter);
                    binding.button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ege.add(binding.editTextText.getText().toString());
                            arrayAdapter.notifyDataSetChanged();
                        }
                    });


                }
                if(i==2){
                    arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, akdeniz);
                    binding.listWiew.setAdapter(arrayAdapter);
                    binding.button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            akdeniz.add(binding.editTextText.getText().toString());
                            arrayAdapter.notifyDataSetChanged();
                        }
                    });

                }


            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






    }
}