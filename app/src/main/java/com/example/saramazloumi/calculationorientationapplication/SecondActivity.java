package com.example.saramazloumi.calculationorientationapplication;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageViewFirstNumber, imageViewSecondNumber, imageViewResult;
    EditText editTextResult;
    TextView textViewShowResult, textViewSign;
    ImageButton imageButtonStart, imageButtonCheck;
    int imageList1[] = {R.drawable.zero, R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight,
    R.drawable.nine};
    int imageList2[] = {R.drawable.zero, R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight,
            R.drawable.nine};
    int index1, index2;
    String orientationChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initialize();

        orientationChoose = (String)getIntent().getExtras().getString("tag");
        switch (orientationChoose){
            case "Portrait":
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                imageViewResult.setImageResource(R.drawable.qface);
                textViewSign.setText("*");
                break;
            case "Landscape":
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                imageViewResult.setImageResource(R.drawable.qface);
                textViewSign.setText("+");
                break;
        }
    }

    private void initialize() {

        imageViewFirstNumber = findViewById(R.id.imageViewFirstNumber);
        imageViewSecondNumber = findViewById(R.id.imageViewSecondNumber);
        textViewShowResult = findViewById(R.id.textViewShowResult);
        imageButtonStart = findViewById(R.id.imageButtonStart);
        imageButtonCheck = findViewById(R.id.imageButtonCheck);
        imageViewResult = findViewById(R.id.imageViewResult);
        editTextResult = findViewById(R.id.editTextResult);
        textViewSign = findViewById(R.id.textViewSign);
        imageViewResult.setImageResource(R.drawable.qface);
        imageButtonStart.setOnClickListener(this);
        imageButtonCheck.setOnClickListener(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        switch (newConfig.orientation){

            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_second);
                break;
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity_second);
                initialize();
                textViewSign.setText("+");
                break;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.imageButtonStart:
                startTimer();
                break;

            case R.id.imageButtonCheck:
                checkResult();
                break;



        }

    }

    private void startTimer() {
        CountDownTimer countDownTimer = new CountDownTimer(8000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

                textViewShowResult.setText(null);
                Random random = new Random();
                index1 = random.nextInt(imageList1.length);
                index2 = random.nextInt(imageList2.length);
                imageViewFirstNumber.setImageResource(imageList1[index1]);
                imageViewSecondNumber.setImageResource(imageList2[index2]);

            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }

    private void checkResult() {

        int result = Integer.valueOf(editTextResult.getText().toString());
        switch (orientationChoose){
            case "Portrait":
                if(result == index1 * index2){
                  textViewShowResult.setText("Bravo");
                  imageViewResult.setImageResource(R.drawable.happy);
                }else{
                    textViewShowResult.setText("Wrong");
                    imageViewResult.setImageResource(R.drawable.sad);
                }
                break;

            case "Landscape":
                if(result == index1 + index2){
                    textViewShowResult.setText("Bravo");
                    imageViewResult.setImageResource(R.drawable.happy);
                }else{
                    textViewShowResult.setText("Wrong");
                    imageViewResult.setImageResource(R.drawable.sad);
                }
                break;
        }

    }



}
