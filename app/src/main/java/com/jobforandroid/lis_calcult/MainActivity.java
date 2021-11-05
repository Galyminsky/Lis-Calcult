package com.jobforandroid.lis_calcult;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    TextView txt;
    int buffer;
    char op;
    
    String expression = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ans = findViewById(R.id. equal);
        ans.setOnClickListener(view -> {
            int val = 0;
            try {
                val = Integer.parseInt(txt.getText().toString());
            } catch (NumberFormatException e) {}
            
            switch (op) {
                case '+':
                    buffer += val;
                    break;
                case '-':
                    buffer -= val;
                    break;
                case '*':
                    buffer *= val;
                    break;
                case '/':
                    try {
                        buffer /= val;
                    } catch (ArithmeticException e) {} //деление на 0
                    break;
            }
            txt.setText(String.valueOf(buffer));
        });

        txt = (TextView) findViewById(R.id.txt);

    }
    public void ops (View view) {
        try {
            buffer = Integer.parseInt(expression);
        } catch (NumberFormatException e) { }
        
        Button b = (Button) view;
        op = b.getText().charAt(0);
        setExpression("");
    }

    public void appendText (View view) {
        Button b = (Button) view;
        setExpression(expression + b.getText().toString());
    }
    
    private void setExpression(String s) {
        expression = s;
        txt.setText(expression);
    }

}
