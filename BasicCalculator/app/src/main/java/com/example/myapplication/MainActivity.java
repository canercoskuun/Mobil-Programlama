package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    int sayi1=0;
    int sayi2=0;
    int sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sayi1=Integer.parseInt(binding.editTextNo1.getText().toString());
        sayi2=Integer.parseInt(binding.editTextNo2.getText().toString());
        String ad=binding.textView.getText().toString();
        String soyad=binding.textView2.getText().toString();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(soyad);
                binding.textView2.setText(ad);
            }
        });
        binding.buttonArpma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayi1=Integer.parseInt(binding.editTextNo1.getText().toString());
                sayi2=Integer.parseInt(binding.editTextNo2.getText().toString());
                sonuc=sayi1*sayi2;
                binding.textViewSonuc.setText(Integer.toString(sonuc));
            }
        });
        binding.buttonBLme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 sayi1=Integer.parseInt(binding.editTextNo1.getText().toString());
                 sayi2=Integer.parseInt(binding.editTextNo2.getText().toString());
                 sonuc=sayi1/sayi2;
                binding.textViewSonuc.setText(Integer.toString(sonuc));
            }
        });
        binding.buttonCKarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayi1=Integer.parseInt(binding.editTextNo1.getText().toString());
                sayi2=Integer.parseInt(binding.editTextNo2.getText().toString());
                sonuc=sayi1-sayi2;
                binding.textViewSonuc.setText(Integer.toString(sonuc));
            }
        });
        binding.buttonToplama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayi1=Integer.parseInt(binding.editTextNo1.getText().toString());
                sayi2=Integer.parseInt(binding.editTextNo2.getText().toString());
                sonuc=sayi1+sayi2;
                binding.textViewSonuc.setText(Integer.toString(sonuc));
            }
        });
    }
}