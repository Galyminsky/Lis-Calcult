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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ans = findViewById(R.id. equal);
        ans.setOnClickListener(view -> {
            switch (op) {
                case '+':
                    buffer += Integer.parseInt( txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
                case '-':
                    buffer -= Integer.parseInt( txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
                case '*':
                    buffer *= Integer.parseInt( txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
                case '/':
                    buffer/= Integer.parseInt( txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
            }
        });

        txt = (TextView) findViewById(R.id.txt);

    }
    public void ops (View view) {
        buffer = Integer.parseInt(txt.getText().toString());
        Button b = (Button) view;
        op = b.getText().charAt(0);
        txt.setText("");
    }

    public void appendText (View view) {
        Button b = (Button) view;
        txt.setText(txt.getText().toString() + b.getText().toString());
    }


}