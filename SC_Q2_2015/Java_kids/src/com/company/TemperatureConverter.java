package com.company;

import java.text.DecimalFormat;

/**
 * Created by imusiievych on 4/30/15.
 */
public class TemperatureConverter {
    public String convertTemp (double temperature, char convertTo){
        double temp = 0;
        String by = null;
        if (convertTo == 'C'){
            temp = (temperature*9/5) + 32.3;
            return "the temperature in Farenheit is: " + customFormat(temp);

        }
        else if (convertTo == 'F') {
            temp = (temperature - 32.2)*5/9;
            return "the temperature in Celsius is: " + customFormat(temp);
        }
        else {
            return "You have entered wrong temperature scale symbol. Please enter either 'C' or 'F' with single quotes. ";
        }
    }

    public static void main(String[] args){

        TemperatureConverter convert1 = new TemperatureConverter();

        System.out.println(convert1.convertTemp(30, 'C'));
        System.out.println(convert1.convertTemp(86, 'F'));
    }

    public static String customFormat(double value){
        DecimalFormat myFormatter = new DecimalFormat("#.00");
        String output = myFormatter.format(value);
        return output;
}

}