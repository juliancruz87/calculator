package com.umb.mobiles.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator
{
    private List<Integer> values = new ArrayList<>();
    private String ops = "";
    private String keys = "";
    private String temporalNumber ="";
    private int result = Integer.MIN_VALUE;
    private String error ="";

    public void Calculate ()
    {
        AddValue();
        long startTime = System.nanoTime();

        if(values.size() > 1)
        {
            result = Operate(values, ops, values.get(0), 1);
            System.out.println(keys+" = "+result);
        }

        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime);
        System.out.println(String.format("Execution time in nanoseconds/milliseconds: %dns / %dms",elapsedTime,elapsedTime/1000000));
    }

    private int Operate (List<Integer> values, String ops,int a,int index)
    {
        int temp = a;
        int b = values.get(index);
        switch(ops.charAt(0))
        {
            case '+':
                temp = a + b;
                break;
            case '-':
                temp = a - b;
                break;
            case 'X':
                temp = a * b;
                break;
            case '/':
                if(a == 0 || b == 0)
                    error = "No se puede dividir por cero";
                else
                    temp = a / b;
                break;
        }

        index++;
        return index == values.size() ? temp : Operate (values, ops.substring(1), temp,index);
    }

    public void AddNumber (String value)
    {
        temporalNumber+= value;
    }

    public void AddValue ()
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

    public void addKey(String key)
    {
        keys+= key;
    }

    public void addoperator (String operator)
    {
        AddValue();
        ops+= operator;
    }

    public void clean()
    {
        error = "";
        ops= "";
        keys="";
        values.clear();
    }

    public String GetTextOperation()
    {
        return keys;
    }

    public String GetResult()
    {
        if(error != "")
            return error;

        return Integer.toString(result);
    }
}