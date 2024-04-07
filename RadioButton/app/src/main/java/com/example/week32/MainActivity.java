package com.example.week32;

import android.graphics.Color;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.week32.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
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
    }
    public void secim(View view) {

        if(binding.radioButtonMavi.isChecked()){
          binding.main.setBackgroundColor(Color.BLUE);
        }
        if(binding.radioButtonKirmizi.isChecked()){
            binding.main.setBackgroundColor(Color.RED);
        }
        if(binding.radioButtonYesil.isChecked()){
            binding.main.setBackgroundColor(Color.GREEN);
        }
        if(binding.radioButtonSiyah.isChecked()){
            binding.main.setBackgroundColor(Color.BLACK);
        }

    }
}