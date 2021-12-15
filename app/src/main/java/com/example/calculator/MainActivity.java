package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.Math;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();

        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
        }
        else{
            String leftStr = oldStr.substring(0, cursorPos);
            String rightStr = oldStr.substring(cursorPos);
            display.setText(leftStr+strToAdd+rightStr);
        }
        display.setSelection(cursorPos + 1);
    }



    public void zeroBTN (View v){
        updateText("0");
    }

    public void oneBTN(View v){
        updateText("1");
    }

    public void twoBTN(View v){
        updateText("2");
    }

    public void threeBTN(View v){
        updateText("3");
    }

    public void fourBTN(View v){
        updateText("4");
    }

    public void fiveBTN(View v){
        updateText("5");
    }

    public void sixBTN(View v){
        updateText("6");
    }

    public void sevenBTN(View v){
        updateText("7");
    }

    public void eightBTN(View v){
        updateText("8");
    }

    public void nineBTN(View v){
        updateText("9");
    }

    public void clearBTN(View v){
        display.setText("");
    }

    public void enterBTN(View v){
        String userExp = display.getText().toString();
        int i = Integer.parseInt(userExp);
        String result = Integer.toBinaryString(i);
        display.setText(result);
        display.setSelection(result.length());
    }
}