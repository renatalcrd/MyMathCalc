package com.example.mymathcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    String firstNum = "";
    String secondNum = "";
    private EditText display;
    boolean isNewOperation = true;
    String operator =  "";
    String num = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.input);
        // disable android keyboard
        display.setShowSoftInputOnFocus(false);

    }

    public void numberClick (View view) {
        int numberLength = display.getText().toString().length();
        if(firstNum.equals("") && operator.equals("")) {
            isNewOperation = false;
            num = display.getText().toString();
            display.setText(num);
        } else {
            if (display.getText().toString().matches("[+\\-*/]")){
                display.setText("");
            }
            isNewOperation=true; //n faz diferenca
            num = display.getText().toString();
        }

        if (numberLength < 20) {
            switch (view.getId()) {
                case R.id.zeroBTN: num += "0";break;
                case R.id.oneBTN: num += "1";break;
                case R.id.twoBTN: num += "2";break;
                case R.id.threeBTN: num += "3";break;
                case R.id.fourBTN: num += "4";break;
                case R.id.fiveBTN: num += "5";break;
                case R.id.sixBTN: num += "6";break;
                case R.id.sevenBTN: num += "7";break;
                case R.id.eightBTN: num += "8";break;
                case R.id.nineBTN: num += "9";break;
                case R.id.decimalBTN: num += ".";break;
                case R.id.negPosBTN:
                    if (!num.equals("")) {
                        if (!num.substring(0, 1).equals("-") && num.length() > 0) {
                            num = "-" + num;
                        } else {
                            num = num.substring(1);
                        }
                        break;
                    }
            }
        }
            display.setText(num);
        }


    public void operatorClick(View view){
        if (!isNewOperation && secondNum.equals("")) {
            firstNum = display.getText().toString();
            switch (view.getId()) {
                case R.id.additionBTN:
                    operator = "+";
                    display.setText("+");
                    break;
                case R.id.subtracBTN:
                    operator = "-";
                    display.setText("-");
                    break;
                case R.id.divisBTN:
                    operator = "/";
                    display.setText("/");
                    break;
                case R.id.multiplBTN:
                    operator = "*";
                    display.setText("*");
                    break;
            }
        } else if (!display.getText().toString().equals("")){
            secondNum = display.getText().toString();
            firstNum = MathCalc.operation(firstNum, secondNum, operator);
            operator="";
            switch (view.getId()) {
                case R.id.additionBTN:
                    operator = "+";
                    display.setText("+");
                    break;
                case R.id.subtracBTN:
                    operator = "-";
                    display.setText("-");
                    break;
                case R.id.divisBTN:
                    operator = "/";
                    display.setText("/");
                    break;
                case R.id.multiplBTN:
                    operator = "*";
                    display.setText("*");
                    break;
            }
        } else {
            display.setText("");
        }

    }

    public void calcClick(View view) {
        secondNum = display.getText().toString();

        if (secondNum.matches("^-?[0-9]\\d*(\\.\\d+)?$") && firstNum.matches("^-?[0-9]\\d*(\\.\\d+)?$")) {
            firstNum = MathCalc.operation(firstNum, secondNum, operator);
            secondNum = "";
            display.setText(firstNum+"");
            isNewOperation = false;
        } else if (firstNum.equals("")  && secondNum.equals("") && operator.equals("")) {
            display.setText("");
        } else { display.setText("Error");}
    }

    public void clearClick(View view) {
        display.setText("");
        firstNum = "";
        secondNum = "";
        operator = "";
        isNewOperation = true;
    }

    public void removeDigClick(View view) {
        String str = display.getText().toString();
        int strLength = str.length();
        if (strLength != 0){
            display.setText(str.substring(0, strLength - 1));
        }
    }
}