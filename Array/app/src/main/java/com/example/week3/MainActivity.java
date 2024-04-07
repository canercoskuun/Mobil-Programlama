package com.example.week3;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.week3.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    int[] numbers;
    ArrayList<String> tek=new ArrayList<>();
    ArrayList<String> cift=new ArrayList<>();
    int min,max;
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
         //String [] title=new String[3];
        //title[0]="First";
        //title[1]="Second";
       // title[2]="Third";
       /* for(int i=0;i<title.length;i++){
            Toast.makeText(this, title[i], Toast.LENGTH_SHORT).show();
        }
        */
     //   String[] title2={"First","Second","Third"};

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random=new Random();
                numbers= new int[10];
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = random.nextInt(100) + 1;
                }

                min=numbers[0];
                max=numbers[0];
                int[] numbers_tek = new int[10];
                int[] numbers_cift = new int[10];

                for(int i=0;i<numbers.length;i++){
                    if(numbers[i]<min){
                        min=numbers[i];
                    }
                    if(numbers[i]>max){
                        max=numbers[i];
                    }
                    if(numbers[i]%2==0){
                        cift.add(Integer.toString(numbers[i]));
                    }
                    else{
                        tek.add(Integer.toString(numbers[i]));
                    }
                }
                String numbersAsString = Arrays.toString(numbers);
                binding.textView2.setText("Sayılar: "+numbersAsString);
                binding.textViewMin.setText("Minimum: "+min);
                binding.textViewMax.setText("Maximum :"+Integer.toString(max));
                binding.textViewTek.setText("Tek sayılar :"+tek.toString());
                binding.textViewCift.setText("Çift sayılar: "+cift.toString());
                tek.clear();
                cift.clear();
            }
        });

      //  String[] title3 = getResources().getStringArray(R.array.kelimeler);
        //for(int i=0;i<title3.length;i++){
          //  Toast.makeText(this, title3[i], Toast.LENGTH_SHORT).show();
        //}



        /*binding.switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    binding.main.setBackgroundResource(R.color.red);
                }
                else{
                    binding.main.setBackgroundResource(R.color.white);

                }
            }
        });
*/



    }
}