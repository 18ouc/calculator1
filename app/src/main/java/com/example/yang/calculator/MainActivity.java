package com.example.yang.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int result = 0;
    int first = 0;
    int second = 0;
    int op = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定各个控件的监听
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btnEqu = (Button) findViewById(R.id.btnEqu);
        Button btnPlus = (Button) findViewById(R.id.btnPlus);
        Button btnMinus = (Button) findViewById(R.id.btnMinus);
        final TextView textView = (TextView) findViewById(R.id.tvResult);

        textView.setText("0");

        //绑定 = 按钮的点击事件
        btnEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (op == 1) {
                    result = first + second;
                    textView.setText(String.valueOf(result));
                }
                if (op == 2) {
                    result = first - second;
                    textView.setText(String.valueOf(result));
                }
            }
        });

        //绑定 1 按钮的点击事件
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("1");
                first = 1;
            }
        });

        //绑定 2 按钮的点击事件
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("2");
                second = 2;
            }
        });

        //绑定 + 按钮的点击事件
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op = 1;
            }
        });

        //绑定 - 按钮的点击事件
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op = 2;
            }
        });
    }

    //对于将内容放置到TextView中这种经常用到的事情，可以写一个函数来进行代码复用
    public void setTextView() {
        TextView textView = (TextView) findViewById(R.id.tvResult);
        textView.setText(String.valueOf(result));
    }
}
