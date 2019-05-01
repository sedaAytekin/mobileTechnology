package com.example.mobiletechnology;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Calculator extends AppCompatActivity {

    @BindView(R.id.formula)
    TextView formula;
    @BindView(R.id.resultBT)
    TextView resultBT;
    @BindView(R.id.btn_clear)
    Button btnClear;
    @BindView(R.id.btn_reset)
    Button btnReset;
    @BindView(R.id.btn_7)
    Button btn7;
    @BindView(R.id.btn_8)
    Button btn8;
    @BindView(R.id.btn_9)
    Button btn9;
    @BindView(R.id.btn_divide)
    Button btnDivide;
    @BindView(R.id.btn_4)
    Button btn4;
    @BindView(R.id.btn_5)
    Button btn5;
    @BindView(R.id.btn_6)
    Button btn6;
    @BindView(R.id.btn_multiply)
    Button btnMultiply;
    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_minus)
    Button btnMinus;
    @BindView(R.id.btn_0)
    Button btn0;
    @BindView(R.id.btn_decimal)
    Button btnDecimal;
    @BindView(R.id.btn_equals)
    Button btnEquals;
    @BindView(R.id.btn_plus)
    Button btnPlus;
    @BindView(R.id.calculator_holder)
    LinearLayout calculatorHolder;
    String value;

    boolean mAddition = false, mDivision = false, mSubtract = false, mMultiplication = false;
    float mValueOne, mValueTwo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        ButterKnife.bind(this);
        getSupportActionBar().hide();


    }

    private void operationClicked(String op)
    {
        formula.setText(formula.getText().toString() + resultBT.getText().toString() + op);
    }
    @OnClick({R.id.formula, R.id.resultBT, R.id.btn_clear, R.id.btn_reset, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_divide, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_multiply, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_minus, R.id.btn_0, R.id.btn_decimal, R.id.btn_equals, R.id.btn_plus, R.id.calculator_holder})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.formula:
                break;
            case R.id.resultBT:
                break;
            case R.id.btn_clear:
                resultBT.setText("");
                formula.setText("");
                break;
            case R.id.btn_reset:
                break;
            case R.id.btn_0:
                value = String.valueOf("0");
                resultBT.setText(resultBT.getText() + "0");
                break;
            case R.id.btn_1:
                value = String.valueOf("1");
                resultBT.setText(resultBT.getText() + "1");
                break;
            case R.id.btn_2:
                value = String.valueOf("2");
                resultBT.setText(resultBT.getText() + "2");
                break;
            case R.id.btn_3:
                value = String.valueOf("3");
                resultBT.setText(resultBT.getText() + "3");
                break;
            case R.id.btn_4:
                value = String.valueOf("4");
                resultBT.setText(resultBT.getText() + "4");
                break;
            case R.id.btn_5:
                value = String.valueOf("5");
                resultBT.setText(resultBT.getText() + "5");
                break;
            case R.id.btn_6:
                value = String.valueOf("6");
                resultBT.setText(resultBT.getText() + "6");
                break;
            case R.id.btn_7:
                value = String.valueOf("7");
                resultBT.setText(resultBT.getText() + "7");
                break;
            case R.id.btn_8:
                value = String.valueOf("8");
                resultBT.setText(resultBT.getText() + "8");
                break;
            case R.id.btn_9:
                value = String.valueOf("9");
                resultBT.setText(resultBT.getText() + "9");
                break;
            case R.id.btn_divide:
                operationClicked("/");
                mValueOne = Float.parseFloat(resultBT.getText() + "");
                mDivision = true;
                resultBT.setText("");
                break;
            case R.id.btn_multiply:
                operationClicked("*");
                mValueOne = Float.parseFloat(resultBT.getText() + "");
                mMultiplication = true;
                resultBT.setText("");
                break;
            case R.id.btn_minus:
                operationClicked("-");
                mValueOne = Float.parseFloat(resultBT.getText() + "");
                mSubtract = true;
                resultBT.setText("");
                break;
            case R.id.btn_decimal:
                value = String.valueOf(".");
                operationClicked(".");
                resultBT.setText(resultBT.getText()+".");
                break;
            case R.id.btn_equals:
                mValueTwo = Float.parseFloat(resultBT.getText() + "");
                formula.setText("");
                if (mAddition) {
                    resultBT.setText(mValueOne + mValueTwo + "");
                    mAddition = false;
                }

                if (mSubtract) {
                    resultBT.setText(mValueOne - mValueTwo + "");
                    mSubtract = false;
                }
                if (mMultiplication) {
                    resultBT.setText(mValueOne * mValueTwo + "");
                    mMultiplication = false;
                }

                if (mDivision) {
                    resultBT.setText(mValueOne / mValueTwo + "");
                    mDivision = false;
                }
                break;
            case R.id.btn_plus:
                    operationClicked("+");
                    mValueOne = Float.parseFloat(resultBT.getText() + "");
                    mAddition = true;
                    resultBT.setText("");
                break;
            case R.id.calculator_holder:
                break;
        }
    }
}
