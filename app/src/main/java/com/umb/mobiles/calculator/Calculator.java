package com.umb.mobiles.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator
{
    private List<Integer> values = new ArrayList<>();
    private String operation = "0";
    private String ops = "";
    private String keys = "";
    private String temporalNumber ="";

    public void Calculate ()
    {
        AddValue();
        long startTime = System.nanoTime();

        if(values.size() > 1)
        {
            int result = Operate(values, ops, values.get(0), 1);
            System.out.println(operation+" = "+result);
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
            case '*':
                temp = a * b;
                break;
            case '/':
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
        ops= "";
        keys="";
        values.clear();
    }
}