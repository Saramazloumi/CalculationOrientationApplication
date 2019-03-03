package com.example.saramazloumi.calculationorientationapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup rbGroup;
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        rbGroup = findViewById(R.id.rbGroup);
        btnGo = findViewById(R.id.btnGo);
        btnGo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, SecondActivity.class);
        int rbId = Integer.valueOf(rbGroup.getCheckedRadioButtonId());

        switch (rbId) {
            case R.id.rbLandscape:
                intent.putExtra("tag", "Landscape");
                break;
            case R.id.rbPortrait:
                intent.putExtra("tag", "Portrait");
                break;
        }
        startActivity(intent);
    }
}
