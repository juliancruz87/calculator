package com.umb.mobiles.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator
{
    public String keys = "";

    private List<Integer> values = new ArrayList<>();
    private String ops = "";
    private String error ="";
    private String temporalNumber ="";
    private int result= Integer.MIN_VALUE;

    public void Calculate ()
    {
        AddValue();

        long startTime = System.nanoTime();

        if(values.size() > 1)
            result = Operate(values, ops, values.get(0), 1);

        long elapsedTime = (System.nanoTime() - startTime);
        System.out.println(String.format("Execution time in nanoseconds/milliseconds: %dns / %dms",elapsedTime,elapsedTime/1000000));
    }

    private int Operate (List<Integer> values, String ops,int a,int index)
    {
        int b = values.get(index);
        switch(ops.charAt(0))
        {
            case '+':
                a += b;
                break;
            case '-':
                a -= b;
                break;
            case 'X':
                a *= b;
                break;
            case '/':
                if(a == 0 || b == 0)
                    error = "No se puede dividir por cero";
                else
                    a /= b;
                break;
        }

        index++;
        return index == values.size() ? a : Operate (values, ops.substring(1), a,index);
    }

    public void AddNumber (String value)
    {
        temporalNumber+= value;
    }

    public void AddOperator(String operator)
    {
        AddValue();
        ops+= operator;
    }

    public void Clean()
    {
        error = "";
        ops= "";
        keys="";
        values.clear();
    }

    public String GetResult()
    {
        if(error != "")
            return error;

        return Integer.toString(result);
    }

    private void AddValue ()
    {
        if(temporalNumber == "" && result != Integer.MIN_VALUE)
        {
            values.add(result);
            keys = result + keys;
        }
        else
            values.add(Integer.parseInt(temporalNumber));
        temporalNumber = "";
    }
}