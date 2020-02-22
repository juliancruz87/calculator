package com.umb.mobiles.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator
{
    private List<Integer> values = new ArrayList<>();
    private String operation = "0";
    private String ops = "++++**/-";

    public void Calculate ()
    {
        long startTime = System.nanoTime();
        values = Arrays.asList(130,24,36,62,18,2,4,2,5);
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
        }

        index++;
        return index == values.size() ? temp : Operate (values, ops.substring(1), temp,index);
    }
}
