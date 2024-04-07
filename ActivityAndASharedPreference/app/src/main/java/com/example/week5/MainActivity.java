package com.example.week5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.week5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String mySharedPreferenceName="myPref";
    SharedPreferences sharedPreferences;
    private ActivityMainBinding binding;


    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences(mySharedPreferenceName, Context.MODE_PRIVATE);
        int red = sharedPreferences.getInt("red",74);
        int green = sharedPreferences.getInt("green",154);
        int blue = sharedPreferences.getInt("blue",172);
        int color= Color.rgb(red,green,blue);
        Log.e("color","red:"+red+" green:"+green+" blue:"+blue+" color:"+color);

        binding.main.setBackgroundColor(color);
    }

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



        SharedPreferences sharedPreferences = getSharedPreferences(mySharedPreferenceName, Context.MODE_PRIVATE);


        int red = sharedPreferences.getInt("red",74);
        int green = sharedPreferences.getInt("green",154);
        int blue = sharedPreferences.getInt("blue",172);
        int color= Color.rgb(red,green,blue);
        binding.main.setBackgroundColor(color);

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });









    }
/*
    public void sp_yaz(View view) {
        String deger1=binding.editTextText.getText().toString();
        String deger2=binding.editTextText2.getText().toString();

        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("name",deger1);
        editor.putString("surname",deger2);
        editor.apply();
        Toast.makeText(this, "Başarıyla Eklendi", Toast.LENGTH_SHORT).show();
    }

    public void sp_oku(View view) {
        String okunandeger1=sharedPreferences.getString("name","default");
        String okunandeger2=sharedPreferences.getString("surname","default");
        binding.editTextText.setText(okunandeger1);
        binding.editTextText2.setText(okunandeger2);

    }

 */
}