package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Model
{
    double result;
    String wynik;
    int pom;
    public double calculate(double numer1,double numer2,String operator)
    {
        switch (operator)
        {
            case "+":
                result=numer1+numer2;
                wynik=Double.toString(result);
                if(wynik.length()>11)
                    break;
                return result;
            case "-":
                result=numer1-numer2;
                return BigDecimal.valueOf(result).setScale(10, RoundingMode.HALF_UP).doubleValue();
            case "*":
                result=numer1*numer2;
                return BigDecimal.valueOf(result).setScale(4, RoundingMode.HALF_UP).doubleValue();
            case "/":
                if(numer2==0)
                    return 0;
                result=numer1/numer2;
                return BigDecimal.valueOf(result).setScale(10, RoundingMode.HALF_UP).doubleValue();
            case "%":
                result=(numer1/100)*numer2;
                return BigDecimal.valueOf(result).setScale(10, RoundingMode.HALF_UP).doubleValue();
        }
        return 0;
    }

    public double calculate2(String operator,double numer1)
    {
        switch (operator)
        {

            case "x²":
                result=numer1*numer1;
                wynik=Double.toString(result);
                if(wynik.length()>11)
                    break;
                return result;

            case "√":
                result=Math.sqrt(numer1);
                return BigDecimal.valueOf(result).setScale(10, RoundingMode.HALF_UP).doubleValue();

            case "±":
                return numer1*(-1);
            case "BIN":
                return Double.parseDouble(Integer.toBinaryString((int)numer1));
            case "DEC":
                int bin=(int)numer1;
                String binaryString=Integer.toString(bin);
                int decimal=Integer.parseInt(binaryString,2);
                return decimal;
            case "⌫":
                wynik=Double.toString(numer1);
                System.out.println(wynik);
                wynik=wynik.substring(1);
                System.out.println(wynik);

                return Double.parseDouble(wynik);
        }
        return 0;
    }
}
