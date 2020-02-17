package com.example.jhe4.buttonclick;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonClickActivity extends AppCompatActivity {
    TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);

        Button onClickBtn = (Button)findViewById(R.id.onClickBtn);
        Button longClickBtn = (Button)findViewById(R.id.longClickBtn);
        Button touchBtn = (Button)findViewById(R.id.touchBtn);

        final ConstraintLayout backgroundImg = (ConstraintLayout)findViewById(R.id.backgroudImg);

        myText = (TextView)findViewById(R.id.myText);

        onClickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myText.setText("Button is Clicked");
                Toast.makeText(getApplicationContext(), "Button is Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        longClickBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                myText.setText("Ater long clicked");
                Toast.makeText(getApplicationContext(), "After long clicked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        touchBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_UP){
                    backgroundImg.setBackgroundResource(R.mipmap.ic_launcher);
                    return true;
                }
                return false;
            }
        });

    }

    public void onclick(View view){
        myText.setText("Button clicked using XML");
        Toast.makeText(getApplicationContext(), "Button Clicked using XML", Toast.LENGTH_SHORT).show();
    }
}
