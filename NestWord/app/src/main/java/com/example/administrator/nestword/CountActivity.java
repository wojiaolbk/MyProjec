package com.example.administrator.nestword;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CountActivity extends AppCompatActivity {

    String symbol = "";
    String one = "";
    String two = "";
    double result = 0;
    private EditText mEditText;
    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        mResult = (TextView) findViewById(R.id.result);
        mEditText = (EditText) findViewById(R.id.ed_content);
    }

    public void one(View view) {
        mEditText.setText(mEditText.getText().toString() + "1");

    }

    public void two(View view) {
        mEditText.setText(mEditText.getText().toString() + "2");
    }

    public void three(View view) {
        mEditText.setText(mEditText.getText().toString() + "3");
    }

    public void four(View view) {
        mEditText.setText(mEditText.getText().toString() + "4");
    }

    public void five(View view) {
        mEditText.setText(mEditText.getText().toString() + "5");
    }

    public void six(View view) {
        mEditText.setText(mEditText.getText().toString() + "6");
    }

    public void seven(View view) {
        mEditText.setText(mEditText.getText().toString() + "7");
    }

    public void eight(View view) {
        mEditText.setText(mEditText.getText().toString() + "8");
    }

    public void nine(View view) {
        mEditText.setText(mEditText.getText().toString() + "9");
    }

    public void zero(View view) {
        mEditText.setText(mEditText.getText().toString() + "0");
    }

    public void point(View view) {
        mEditText.setText(mEditText.getText().toString() + ".");
    }

    public void jia(View view) {
        symbol = "jia";
        one = mEditText.getText().toString();
        mEditText.setText(mEditText.getText().toString() + "+");
    }

    public void jian(View view) {
        symbol = "jian";
        one = mEditText.getText().toString();
        mEditText.setText(mEditText.getText().toString() + "-");
    }

    public void cheng(View view) {
        symbol = "cheng";
        one = mEditText.getText().toString();
        mEditText.setText(mEditText.getText().toString() + "*");
    }


    public void clear(View view) {
        mEditText.setText("");
    }

    public void euqel(View view) {
        String trim = mEditText.getText().toString().trim();
        int i1;
        switch (symbol) {
            case "jia":
                i1 = trim.indexOf("+");
                two = trim.substring(i1 + 1, trim.length());
                break;
            case "jian":
                i1 = trim.indexOf("-");
                two = trim.substring(i1 + 1, trim.length());
                break;
            case "cheng":
                i1 = trim.indexOf("*");
                two = trim.substring(i1 + 1, trim.length());
                break;
        }

        switch (symbol) {
            case "jia":
                result = Double.parseDouble(one) + Double.parseDouble(two);
                break;
            case "jian":
                result = Double.parseDouble(one) - Double.parseDouble(two);
                break;
            case "cheng":
                System.out.println(one);
                System.out.println(two);
                result = Double.parseDouble(one) * Double.parseDouble(two);
                break;
        }
        mResult.setText("结果：" + result);
        mEditText.setHint("" + result);
        mEditText.setText("");

    }

}
