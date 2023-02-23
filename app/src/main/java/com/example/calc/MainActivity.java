package com.example.calc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    TextView textView2;
    ImageButton imageButton;
    EditText textView1;
    Button one, two, three, four, five, six, seven, eight, nine, zero, clear, percentage, backspace, add, sub, mul, div, brackets, dot, equal;
    Boolean DOT = false, BRACKETS = false, ADD = false, SUB = false, MUL = false, DIV = false, PERCENTAGE = false, START = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.imageButton);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        brackets = findViewById(R.id.brackets);
        clear = findViewById(R.id.clear);
        percentage = findViewById(R.id.percentage);
        backspace = findViewById(R.id.backspace);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        dot = findViewById(R.id.dot);
        equal = findViewById(R.id.equal);

        textView1.setKeyListener(null);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        textView1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int textLength = s.length();
                textView1.setSelection(textLength);
            }
        });


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(textView1.getText() + "1");
                if (BRACKETS == false) {
                    double result = evaluate(textView1.getText().toString());
                    if (START == true) {
                        textView2.setText(String.valueOf(result));
                    }
                }
                ADD = false;
                SUB = false;
                MUL = false;
                DIV = false;
                PERCENTAGE = false;

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(textView1.getText() + "2");
                if (BRACKETS == false) {
                    double result = evaluate(textView1.getText().toString());
                    if (START == true) {
                        textView2.setText(String.valueOf(result));
                    }
                    ADD = false;
                    SUB = false;
                    MUL = false;
                    DIV = false;
                    PERCENTAGE = false;
                }
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(textView1.getText() + "3");
                if (BRACKETS == false) {
                    double result = evaluate(textView1.getText().toString());
                    if (START == true) {
                        textView2.setText(String.valueOf(result));
                    }
                    ADD = false;
                    SUB = false;
                    MUL = false;
                    DIV = false;
                    PERCENTAGE = false;
                }
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(textView1.getText() + "4");
                double result = evaluate(textView1.getText().toString());
                if (START == true) {
                    textView2.setText(String.valueOf(result));
                }
                ADD = false;
                SUB = false;
                MUL = false;
                DIV = false;
                PERCENTAGE = false;
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(textView1.getText() + "5");
                double result = evaluate(textView1.getText().toString());
                if (START == true) {
                    textView2.setText(String.valueOf(result));
                }
                ADD = false;
                SUB = false;
                MUL = false;
                DIV = false;
                PERCENTAGE = false;
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(textView1.getText() + "6");
                double result = evaluate(textView1.getText().toString());
                if (START == true) {
                    textView2.setText(String.valueOf(result));
                }
                ADD = false;
                SUB = false;
                MUL = false;
                DIV = false;
                PERCENTAGE = false;
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(textView1.getText() + "7");
                double result = evaluate(textView1.getText().toString());
                if (START == true) {
                    textView2.setText(String.valueOf(result));
                }
                ADD = false;
                SUB = false;
                MUL = false;
                DIV = false;
                PERCENTAGE = false;
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(textView1.getText() + "8");
                double result = evaluate(textView1.getText().toString());
                if (START == true) {
                    textView2.setText(String.valueOf(result));
                }
                ADD = false;
                SUB = false;
                MUL = false;
                DIV = false;
                PERCENTAGE = false;
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(textView1.getText() + "9");
                double result = evaluate(textView1.getText().toString());
                if (START == true) {
                    textView2.setText(String.valueOf(result));
                }
                ADD = false;
                SUB = false;
                MUL = false;
                DIV = false;
                PERCENTAGE = false;
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(textView1.getText() + "0");
                double result = evaluate(textView1.getText().toString());
                if (START == true) {
                    textView2.setText(String.valueOf(result));
                }
                ADD = false;
                SUB = false;
                MUL = false;
                DIV = false;
                PERCENTAGE = false;
            }
        });
        brackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                textView1.setText(textView1.getText() + "00");
//                double result = evaluate(textView1.getText().toString());
//                textView2.setText(String.valueOf(result));

                if (BRACKETS == false) {
                    textView1.setText(textView1.getText() + "(");
                    BRACKETS = true;
                } else if (BRACKETS = true) {
                    textView1.setText(textView1.getText() + ")");
                    BRACKETS = false;
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView1.getText().length() > 0) {
                    if (ADD == false) {
                        textView1.setText(textView1.getText() + "+");
                        DOT = false;
                        ADD = true;
                        SUB = true;
                        MUL = true;
                        DIV = true;
                        PERCENTAGE = true;
                        START = true;
                    }
                } else {
                    textView1.setText("");
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView1.getText().length() > 0) {
                    if (SUB == false) {
                        textView1.setText(textView1.getText() + "-");
                        DOT = false;
                        ADD = true;
                        SUB = true;
                        MUL = true;
                        DIV = true;
                        PERCENTAGE = true;
                        START = true;
                    }
                } else {
                    textView1.setText("");
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView1.getText().length() > 0) {
                    if (MUL == false) {
                        textView1.setText(textView1.getText() + "*");
                        DOT = false;
                        ADD = true;
                        SUB = true;
                        MUL = true;
                        DIV = true;
                        PERCENTAGE = true;
                        START = true;

                    }
                } else {
                    textView1.setText("");
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView1.getText().length() > 0) {
                    if (DIV == false) {
                        textView1.setText(textView1.getText() + "/");
                        DOT = false;
                        ADD = true;
                        SUB = true;
                        MUL = true;
                        DIV = true;
                        PERCENTAGE = true;
                        START = true;
                    }
                } else {
                    textView1.setText("");
                }
            }
        });
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView1.getText().length() > 0) {
                    if (PERCENTAGE == false) {
                        textView1.setText(textView1.getText() + "%");
                        double result = evaluate(textView1.getText().toString());
                        textView2.setText(String.valueOf(result / 100));
                        DOT = false;
                        PERCENTAGE = true;
                        ADD = true;
                        SUB = true;
                        MUL = true;
                        DIV = true;
                    }
                } else {
                    textView1.setText("");
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("");
                textView2.setText("");
                BRACKETS = false;
                DOT = false;
                ADD = false;
                SUB = false;
                MUL = false;
                DIV = false;
                PERCENTAGE = false;
                START = false;
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textView1.getText().toString();
                if (str.length() > 0) {
                    str = str.substring(0, str.length() - 1);
                    textView1.setText(str);
                } else if (str.length() <= 0) {
                    textView1.setText("");
                }
                double result = evaluate(textView1.getText().toString());
                textView2.setText(String.valueOf(result));
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DOT == false) {
                    if (textView1.getText().length() > 0) {
                        textView1.setText(textView1.getText() + ".");
                    } else {
                        textView1.setText(textView1.getText() + "0.");
                    }
                    DOT = true;
                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView1.getText().length() > 0) {
                    DOT = true;
                    double result = evaluate(textView1.getText().toString());
                    textView1.setText(String.valueOf(result));
                    textView2.setText("");
                    BRACKETS = false;
                    DOT = false;
                    ADD = false;
                    SUB = false;
                    MUL = false;
                    DIV = false;
                    PERCENTAGE = false;

                } else {
                    textView1.setText("");
                }
            }
        });
    }

    public static double evaluate(String equation) {
        Stack<Double> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        String numStr = "";
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                numStr += c;
            } else {
                if (!numStr.isEmpty()) {
                    double num = Double.parseDouble(numStr);
                    numStack.push(num);
                    numStr = "";
                }
                if (c == '(') {
                    opStack.push(c);
                } else if (c == ')') {
                    while (opStack.peek() != '(') {
                        char op = opStack.pop();
                        double num2 = numStack.pop();
                        double num1 = numStack.pop();
                        double result = evaluateOperation(num1, num2, op);
                        numStack.push(result);
                    }
                    opStack.pop();
                } else if (isOperator(c)) {
                    while (!opStack.empty() && hasHigherPrecedence(opStack.peek(), c)) {
                        char op = opStack.pop();
                        double num2 = numStack.pop();
                        double num1 = numStack.pop();
                        double result = evaluateOperation(num1, num2, op);
                        numStack.push(result);
                    }
                    opStack.push(c);
                }
            }
        }
        if (!numStr.isEmpty()) {
            double num = Double.parseDouble(numStr);
            numStack.push(num);
        }
        while (!opStack.empty()) {
            char op = opStack.pop();
            double num2 = numStack.pop();
            double num1 = numStack.pop();
            double result = evaluateOperation(num1, num2, op);
            numStack.push(result);
        }
        return numStack.pop();
    }

    public static boolean isOperator(char op) {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }

    public static int getPrecedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    public static boolean hasHigherPrecedence(char op1, char op2) {
        int prec1 = getPrecedence(op1);
        int prec2 = getPrecedence(op2);
        return prec1 >= prec2;
    }

    public static double evaluateOperation(double num1, double num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}