package com.pasha.landcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TriangleActivity<puclic> extends AppCompatActivity
{
    private TextView txtSideA1, txtSideB1, txtSideC1,txtArea1, txtGhz1, txtBisec1, txtAreaMtr1, txtBackBtn1;
    private EditText editSideA1, editSideB1, editSideC1;
    private Button CalculateBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        txtSideA1 = (TextView) findViewById(R.id.side_a1);
        txtSideB1 = (TextView) findViewById(R.id.side_b1);
        txtSideC1 = (TextView) findViewById(R.id.side_c1);
        txtArea1 = (TextView) findViewById(R.id.txt_area1);
        txtAreaMtr1 = (TextView) findViewById(R.id.area_mtr1);
        txtGhz1 = (TextView) findViewById(R.id.ghz_area1);
        txtBisec1 = (TextView) findViewById(R.id.bisec_area1);
        txtBackBtn1 = (TextView) findViewById(R.id.txt_back_btn1);


        editSideA1 = (EditText) findViewById(R.id.edit_a1);
        editSideB1 = (EditText) findViewById(R.id.edit_b1);
        editSideC1 = (EditText) findViewById(R.id.edit_c1);

        CalculateBtn1 = (Button) findViewById(R.id.calculate_btn1);

        txtBackBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TriangleActivity.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });
    }


    public void add(View view)
    {
        double s1 = 0;
        double q1 = 0;
        double biseec1 = 0;
        double ghzs1 = 0;
        double area1 = 0;

        Double a1 = Double.parseDouble(editSideA1.getText().toString());
        Double b1 = Double.parseDouble(editSideB1.getText().toString());
        Double c1 = Double.parseDouble(editSideC1.getText().toString());

        area1 = Math.sqrt((s1*(s1 - a1) * (s1 - b1) * (s1 - c1)));

        s1 = (a1 + b1 + c1) / 2;

        q1 = area1 / 3.29;

        ghzs1 = area1 / 7.5625;

        biseec1 = ghzs1 / 45;

        txtArea1.setText(String.valueOf(Math.round(area1 * 100.00) / 100.00 + "   (Sq-feet)"));
        txtAreaMtr1.setText(String.valueOf(Math.round(q1 * 100.00) / 100.00 + "   (Sq-mtr)"));

        txtGhz1.setText(String.valueOf(Math.round(ghzs1 * 100.00) / 100.00));

        txtBisec1.setText(String.valueOf(Math.round(biseec1 * 100.00) / 100.00));


        CloseKeyBoardToTriangle();
    }

    private void CloseKeyBoardToTriangle()
    {
        View view = this.getCurrentFocus();
        if (view != null)
        {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}