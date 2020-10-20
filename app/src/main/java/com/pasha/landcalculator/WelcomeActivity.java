package com.pasha.landcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity
{
    private Button TriangleBtn, RectangleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        TriangleBtn = (Button) findViewById(R.id.tri_image_btn);
        RectangleBtn = (Button) findViewById(R.id.rect_image_btn);


        RectangleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(WelcomeActivity.this,RectangleActivity.class);
                startActivity(intent);
            }
        });


        TriangleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(WelcomeActivity.this,TriangleActivity.class);
                startActivity(intent);
            }
        });
    }
}