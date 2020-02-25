package com.umb.mobiles.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Calculator calculator = new Calculator();
    private TextView text;
    private int [] buttons = new int []  {  R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six,
                                            R.id.seven, R.id.eight, R.id.nine, R.id.zero, R.id.plus, R.id.minus,
                                            R.id.multiplication, R.id.divide, R.id.clean, R.id.equal };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Go fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.Etiqueta);

        for (int i= 0; i < buttons.length; i++)
        {
            Button btn = findViewById(buttons[i]);
            btn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    OnButtonPressed(((Button) v).getText().toString(), v.getId());
                }
            });
        }
    }

    private void OnButtonPressed(String button, int id)
    {
        if(id == R.id.equal)
        {
            calculator.Calculate();
            text.setText(calculator.GetResult());
            calculator.Clean();
            return;
        }
        else if(id == R.id.clean)
        {
            calculator.Clean();
            text.setText("0");
            return;
        }

        calculator.keys += button;

        if(id == R.id.plus || id == R.id.minus || id == R.id.multiplication || id == R.id.divide)
            calculator.AddOperator(button);
        else
            calculator.AddNumber(button);

        text.setText(calculator.keys);
    }
}