package com.example.jhe4.uiapp;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import static com.example.jhe4.uiapp.R.id.radioGroup;

public class UIAppActivity extends AppCompatActivity {
    RadioGroup myRG;
    SeekBar mySB;
    CheckBox myCB1, myCB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiapp);

        myRG = (RadioGroup)findViewById(R.id.radioGroup);
        myCB1 = (CheckBox)findViewById(R.id.checkBox1);
        myCB2 = (CheckBox)findViewById(R.id.checkBox2);

        myCB1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView == myCB1 && isChecked)
                    Toast.makeText(getApplicationContext(),myCB1.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        myCB2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView == myCB2 && isChecked)
                    Toast.makeText(getApplicationContext(),myCB2.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        mySB = (SeekBar)findViewById(R.id.seekBar);

        myRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int currentId = myRG.getCheckedRadioButtonId();
                RadioButton currentRB = (RadioButton)findViewById(currentId);
                Toast.makeText(getApplicationContext(), currentRB.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        mySB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getApplicationContext(),"The current progress is "+ mySB.getProgress(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}

