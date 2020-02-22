package com.umb.mobiles.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Go fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.one);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });
        Button btn2 = findViewById(R.id.two);
        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });
        Button btn3 = findViewById(R.id.three);
        btn3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });
        Button btn4 = findViewById(R.id.four);
        btn4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });
        Button btn5 = findViewById(R.id.five);
        btn5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });
        Button btn6 = findViewById(R.id.six);
        btn6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });
        Button btn7 = findViewById(R.id.seven);
        btn7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });
        Button btn8 = findViewById(R.id.eight);
        btn8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });
        Button btn9 = findViewById(R.id.nine);
        btn9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });
        Button btn0 = findViewById(R.id.zero);
        btn0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });
        Button btnplus = findViewById(R.id.plus);
        btnplus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });
        Button btnminus = findViewById(R.id.minus);
        btnminus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });
        Button btnmultiplication = findViewById(R.id.multiplication);
        btnmultiplication.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });
        Button btndivide = findViewById(R.id.divide);
        btndivide.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });
        Button btnequal = findViewById(R.id.equal);
        btnequal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });
        Button btndot = findViewById(R.id.dot);
        btndot.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                OnButtonPressed(((Button) v).getText().toString());
            }
        });

    }

    private void OnButtonPressed(String button)
    {
        Calculator calculator = new Calculator();
        Log.i("Calculator 1", button);
        calculator.Calculate();
    }
}
