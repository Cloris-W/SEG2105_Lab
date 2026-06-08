package com.example.lab3simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private enum Operator { none, add, minus, multiply, divide, eq }
    private double data1 = 0, data2 = 0;
    private Operator optr = Operator.none;
    private boolean requiresCleaning = false;
    private boolean hasDot = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void btn00Click(View view) {
        appendNumber("0");
    }

    public void btn01Click(View view) {
        appendNumber("1");
    }

    public void btn02Click(View view) {
        appendNumber("2");
    }

    public void btn03Click(View view) {
        appendNumber("3");
    }

    public void btn04Click(View view) {
        appendNumber("4");
    }

    public void btn05Click(View view) {
        appendNumber("5");
    }

    public void btn06Click(View view) {
        appendNumber("6");
    }

    public void btn07Click(View view) {
        appendNumber("7");
    }

    public void btn08Click(View view) {
        appendNumber("8");
    }

    public void btn09Click(View view) {
        appendNumber("9");
    }

    private void appendNumber(String num) {
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        if (requiresCleaning) {
            eText.setText("");
            requiresCleaning = false;
        }
        eText.setText(eText.getText() + num);
    }

    public void btnAddClick(View view) {
        handleOperator(Operator.add);
    }

    public void btnSubClick(View view) {
        handleOperator(Operator.minus);
    }

    public void btnMultClick(View view) {
        handleOperator(Operator.multiply);
    }

    public void btnDivClick(View view) {
        handleOperator(Operator.divide);
    }

    private void handleOperator(Operator op) {
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        String text = eText.getText().toString();
        if (!text.isEmpty()) {
            data1 = Double.parseDouble(text);
            optr = op;
            eText.setText("");
            hasDot = false;
        }
    }

    public void btnDotClick(View view) {
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        if (requiresCleaning) {
            eText.setText("");
            requiresCleaning = false;
            hasDot = false;
        }
        if (!hasDot) {
            eText.setText(eText.getText() + ".");
            hasDot = true;
        }
    }

    public void btnCeClick(View view) {
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        eText.setText("");
        data1 = 0;
        data2 = 0;
        optr = Operator.none;
        hasDot = false;
        requiresCleaning = false;
    }

    public void btnResultClick(View view) {
        if (optr != Operator.none) {
            TextView eText = (TextView) findViewById(R.id.resultEdit);
            String text = eText.getText().toString();
            if (!text.isEmpty()) {
                data2 = Double.parseDouble(text);
                double result = 0;
                boolean error = false;
                if (optr == Operator.add) {
                    result = data1 + data2;
                } else if (optr == Operator.minus) {
                    result = data1 - data2;
                } else if (optr == Operator.multiply) {
                    result = data1 * data2;
                } else if (optr == Operator.divide) {
                    if (data2 != 0) {
                        result = data1 / data2;
                    } else {
                        error = true;
                    }
                }

                if (error) {
                    eText.setText("Error");
                } else {
                    eText.setText(String.valueOf(result));
                }
                optr = Operator.none;
                requiresCleaning = true;
                hasDot = false;
            }
        }
    }
}