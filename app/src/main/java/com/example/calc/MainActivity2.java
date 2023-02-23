package com.example.calc;

import android.content.Intent;
import android.speech.RecognizerIntent;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Stack;

public class MainActivity2 extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1;
    EditText textView3;
    private TextView textView4;
    private Button speakButton;

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        textView3 = findViewById(R.id.textView3);
        textView4= findViewById(R.id.textView4);
        speakButton = findViewById(R.id.speakButton);

        textView3.setKeyListener(null);

        textView3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int a=textView3.length();
                textView3.setSelection(a);
            }
        });

        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptSpeechInput();

            }
        });


    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak something");
        startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textView3.setText(result.get(0));
                    double result1 = evaluate(textView3.getText().toString());
                    textView4.setText(String.valueOf(result1));
                }
                break;
            }
        }
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
