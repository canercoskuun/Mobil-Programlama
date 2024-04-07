package com.example.week2;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.week2.databinding.ActivityMainBinding;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ArrayList<String>meyveler=new ArrayList<>();
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
        binding.textView.setText("Seçili meyve yok!");



    }
   public void Deneme(View view) {
        meyveler.clear();
        if (binding.checkBoxArmut.isChecked()) {
            meyveler.add("Armut");
        } 
        if (binding.checkBoxElma.isChecked()) {
            meyveler.add("Elma");
        }
        if (binding.checkBoxMandalina.isChecked()) {
            meyveler.add("Mandalina");
        }
        if (binding.checkBoxMuz.isChecked()) {
            meyveler.add("Muz");
        }
        if (binding.checkBoxPortakal.isChecked()) {
            meyveler.add("Portakal");
        }
        if (meyveler.isEmpty()) {
            binding.textView.setText("Seçili meyve yok!");
        } else {
            binding.textView.setText(meyveler.toString());
        }
    }

}
