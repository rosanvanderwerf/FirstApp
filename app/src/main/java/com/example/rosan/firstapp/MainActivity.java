package com.example.rosan.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText amount;
    private EditText percentage;
    private TextView tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.amount);
        percentage = findViewById(R.id.percentage);
        tip = findViewById(R.id.tip);
    }

    // When onSaveInstanceState is called
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String tip_saved = tip.getText().toString();
        outState.putString("s_tip", tip_saved);
    }

    // To do when state is restored
    @Override
    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);

        String tip_restored = inState.getString("s_tip");
        tip.setText("");
        tip.setText(tip_restored);
    }

    public void buttonCommit(View view) {
        String amount_string = amount.getText().toString();
        String percentage_string = percentage.getText().toString();

        if (amount_string.trim().equals("")) {
            Toast.makeText(MainActivity.this, "Please enter an amount", Toast.LENGTH_SHORT).show();
            return; }
        if (percentage_string.trim().equals("")) {
            Toast.makeText(MainActivity.this, "Please enter an amount", Toast.LENGTH_SHORT).show();
            return; }

        float amount_float = Float.parseFloat(amount_string);
        float percentage_float = Float.parseFloat(percentage_string);

        float tip_float = amount_float * percentage_float/100;
        String tip_string = String.format("%.2f", tip_float);
        tip.setText(tip_string);
    }

    public void buttonReset(View view) {
        amount.setText("");
        percentage.setText("");
        tip.setText("");

    }
}
