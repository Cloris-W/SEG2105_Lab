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

    private enum Operator { none, add, sub, mul, div, eq }
    private double data01 = 0, data02 = 0;
    private Operator opp = Operator.none;
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

    public void onClickNumericalButton(View view) {
        int pressID = view.getId();
        TextView curText = (TextView) findViewById(R.id.resultEdit);

        if (opp == Operator.eq) {
            opp = Operator.none;
            curText.setText("");
            hasDot = false;
        }

        if (requiresCleaning) {
            requiresCleaning = false;
            curText.setText("");
            hasDot = false;
        }

        if (pressID == R.id.button00) {
            curText.append("0");
        } else if (pressID == R.id.button01) {
            curText.append("1");
        } else if (pressID == R.id.button02) {
            curText.append("2");
        } else if (pressID == R.id.button03) {
            curText.append("3");
        } else if (pressID == R.id.button04) {
            curText.append("4");
        } else if (pressID == R.id.button05) {
            curText.append("5");
        } else if (pressID == R.id.button06) {
            curText.append("6");
        } else if (pressID == R.id.button07) {
            curText.append("7");
        } else if (pressID == R.id.button08) {
            curText.append("8");
        } else if (pressID == R.id.button09) {
            curText.append("9");
        } else if (pressID == R.id.buttonDot) {
            if (!hasDot) {
                curText.append(".");
                hasDot = true;
            }
        } else {
            curText.setText("ERROR");
        }
    }

    public void onClickFunctionButton(View view) {
        int pressID = view.getId();
        TextView curText = (TextView) findViewById(R.id.resultEdit);

        if (pressID == R.id.buttonCe) {
            opp = Operator.none;
            curText.setText("");
            data01 = 0;
            data02 = 0;
            requiresCleaning = false;
            hasDot = false;
            return;
        }

        String dataText = curText.getText().toString();
        double numberVal = dataText.length() > 0 ? Double.parseDouble(dataText) : 0;

        if (opp == Operator.none) {
            data01 = numberVal;
            requiresCleaning = true;
            if (pressID == R.id.buttonAdd) {
                opp = Operator.add;
            } else if (pressID == R.id.buttonSub) {
                opp = Operator.sub;
            } else if (pressID == R.id.buttonMult) {
                opp = Operator.mul;
            } else if (pressID == R.id.buttonDiv) {
                opp = Operator.div;
            }
        } else {
            data02 = numberVal;
            double result = 0;
            boolean error = false;
            switch (opp) {
                case add: result = data01 + data02; break;
                case sub: result = data01 - data02; break;
                case mul: result = data01 * data02; break;
                case div:
                    if (data02 != 0) {
                        result = data01 / data02;
                    } else {
                        error = true;
                    }
                    break;
            }
            if (error) {
                curText.setText("Error");
                data01 = 0;
                opp = Operator.none;
            } else {
                data01 = result;
                if (pressID == R.id.buttonEq) {
                    opp = Operator.eq;
                } else if (pressID == R.id.buttonAdd) {
                    opp = Operator.add;
                } else if (pressID == R.id.buttonSub) {
                    opp = Operator.sub;
                } else if (pressID == R.id.buttonMult) {
                    opp = Operator.mul;
                } else if (pressID == R.id.buttonDiv) {
                    opp = Operator.div;
                }
                curText.setText(String.valueOf(result));
            }
            requiresCleaning = true;
            hasDot = false;
        }
    }
}