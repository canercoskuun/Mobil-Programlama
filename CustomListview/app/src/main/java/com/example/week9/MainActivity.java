package com.example.week9;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.week9.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<User> KisiList = new ArrayList<User>();
    ListView listView ;
    KisiAdapter adaptor;
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

        listView = findViewById(R.id.liste);

            KisiList.add(new User("Ugur","43","12",true));
        KisiList.add(new User("Ada","15","18",false));

        adaptor = new KisiAdapter(this,KisiList);
        listView.setAdapter(adaptor);

binding.button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        boolean cinsiyet = false;
        if(binding.radioButtonErkek.isChecked())
        {
            cinsiyet = true;
        }
        KisiList.add(new User(binding.editTextName.getText().toString(),binding.editTextSurname.getText().toString(),binding.editTextYas.getText().toString(),cinsiyet));
        adaptor.notifyDataSetChanged();
    }
});

    }
}