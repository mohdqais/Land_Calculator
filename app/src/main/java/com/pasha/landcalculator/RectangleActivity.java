package com.pasha.landcalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RectangleActivity extends AppCompatActivity {
    private TextView txtSideA, txtSideB, txtSideC, txtSideD, txtArea, txtGhz, txtBisec, txtAreaMtr, txtBackBtn;
    private EditText editSideA, editSideB, editSideC, editSideD;
    private Button CalculateBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        txtSideA = (TextView) findViewById(R.id.side_a);
        txtSideB = (TextView) findViewById(R.id.side_b);
        txtSideC = (TextView) findViewById(R.id.side_c);
        txtSideD = (TextView) findViewById(R.id.side_d);
        txtArea = (TextView) findViewById(R.id.txt_area);
        txtAreaMtr = (TextView) findViewById(R.id.area_mtr);
        txtGhz = (TextView) findViewById(R.id.ghz_area);
        txtBisec = (TextView) findViewById(R.id.bisec_area);
        txtBackBtn = (TextView) findViewById(R.id.txt_back_btn);



        editSideA = (EditText) findViewById(R.id.edit_a);
        editSideB = (EditText) findViewById(R.id.edit_b);
        editSideC = (EditText) findViewById(R.id.edit_c);
        editSideD = (EditText) findViewById(R.id.edit_d);


        CalculateBtn = (Button) findViewById(R.id.calculate_btn);

        txtBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RectangleActivity.this,WelcomeActivity.class);
                startActivity(intent);
            }
        });



        editSideA.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionID, KeyEvent keyEvent)
            {
                if (actionID == EditorInfo.IME_ACTION_NEXT)
                {
                    editSideB.requestFocus();
                }
                return false;
            }
        });
    }

    public void area(View view)
    {

        double s = 0;
        double q = 0;
        double biseec = 0;
        double ghzs = 0;
        double area = 0;

        Double a = Double.parseDouble(editSideA.getText().toString());
        Double b = Double.parseDouble(editSideB.getText().toString());
        Double c = Double.parseDouble(editSideC.getText().toString());
        Double d = Double.parseDouble(editSideD.getText().toString());

        area = Math.sqrt((s-a)*(s-b)*(s-c)*(s-d));

        s = (a + b + c + d)/2;

        q =  area/3.29;

        ghzs = area/7.5625;

        biseec = ghzs/45;

        txtArea.setText(String.valueOf(Math.round(area*100.00)/100.00 + "   (Sq-feet)"));
        txtAreaMtr.setText(String.valueOf(Math.round(q*100.00)/100.00 + "   (Sq-mtr)"));

        txtGhz.setText(String.valueOf(Math.round(ghzs*100.00)/100.00));

        txtBisec.setText(String.valueOf(Math.round(biseec*100.00)/100.00));

        CloseKeyBoard();

    }

    private void CloseKeyBoard()
    {
        View view = this.getCurrentFocus();
        if (view != null)
        {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}