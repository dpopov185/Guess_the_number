package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvinfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvinfo = (TextView)findViewById(R.id.textView2);
        etInput = (EditText)findViewById(R.id.editTextPersonName);
        bControl = (Button)findViewById(R.id.button2);

        guess = (int)(Math.random()*100);
        gameFinished = false;

    }

    public void onClick(View v){

        if(!gameFinished){
            int inp = Integer.parseInt(etInput.getText().toString());
            if (inp > guess)
                tvinfo.setText(getResources().getString(R.string.ahead));
            if (inp < guess)
                //tvinfo.setText(getResources().getString(R.string.behind));
                tvinfo.setText("Недобор...");
            if (inp == guess)
            {
                tvinfo.setText("В точку!");
                bControl.setText(getResources().getString(R.string.play_more));
                gameFinished=true;
            }
        }
        else
        {
            guess = (int)Math.random()*100;
            bControl.setText("Введите значение");
            tvinfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished=false;
        }

    }
}