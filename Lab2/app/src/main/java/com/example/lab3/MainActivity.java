//Raj Kapadia
//1/19/20


package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup myRG1;
    RadioGroup myRG2;
    RadioButton crispy, thick, soggy;
    RadioButton store, pickup, delivery;
    SeekBar mySB;
    CheckBox anch, pine, onion, garlic;
    TextView size, price;
    double total,area, size_p;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRG1 = (RadioGroup) findViewById(R.id.crust_group);
        myRG2 = (RadioGroup) findViewById(R.id.location);
        mySB = (SeekBar) findViewById(R.id.size_seek);
        size = (TextView) findViewById(R.id.seek_display);
        price = (TextView) findViewById(R.id.price);
        crispy = (RadioButton) findViewById(R.id.crispy_rad);
        thick = (RadioButton) findViewById(R.id.thick_rad);
        soggy = (RadioButton) findViewById(R.id.soggy_rad);
        anch = (CheckBox) findViewById(R.id.anch_check);
        pine = (CheckBox) findViewById(R.id.pine_check);
        garlic = (CheckBox) findViewById(R.id.gar_check);
        onion = (CheckBox) findViewById(R.id.onion_check);
        store = (RadioButton) findViewById(R.id.store);
        pickup = (RadioButton) findViewById(R.id.pickup);
        delivery = (RadioButton) findViewById(R.id.deliver);







        mySB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                size.setText(Integer.toString(progress) + " in");
                Calc_price();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                size.setText(Integer.toString(seekBar.getProgress()) + " in");
                Calc_price();


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                size.setText(Integer.toString(seekBar.getProgress()) + " in");
                Calc_price();

            }
        });

        myRG1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Calc_price();


            }
        });

        myRG2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Calc_price();

            }
        });

        anch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Calc_price();
            }
        });

        pine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Calc_price();
            }
        });

        garlic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Calc_price();
            }
        });

        onion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Calc_price();
            }
        });




    }//onCreate

    public void Calc_price(){


        size_p = mySB.getProgress();
        area = (Math.PI) * (Math.pow((size_p/2), 2));

        total = 0;

        //check crust
        if(crispy.isChecked()){
            total += 0;
        }
        if(thick.isChecked()){
            total += 2.50;
        }
        if(soggy.isChecked()){
            total += 5.00;
        }


        //check location
        if(store.isChecked()){
            total+= 0;
        }
        if(pickup.isChecked()){
            total +=0;

        }
        if(delivery.isChecked()){
            total+= 3.00;
        }


        //initialize and check toppings
        int toppingCount =0;

        if(anch.isChecked()){
            toppingCount++;
        }
        if(pine.isChecked()){
            toppingCount++;
        }
        if(onion.isChecked()){
            toppingCount++;
        }
        if(garlic.isChecked()){
            toppingCount++;
        }

        double sizeBasedPrice = area *0.05;

        double toppingPrice = toppingCount*0.05*area;
        total += sizeBasedPrice;
        total += toppingPrice;



        price.setText(String.format("$"+"%.2f",total));

    }


}
