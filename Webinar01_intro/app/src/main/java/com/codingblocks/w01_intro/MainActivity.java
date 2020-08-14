package com.codingblocks.w01_intro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    EditText etVar1, etVar2;
//    Button btnAdd;
//    TextView tvResult;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnAdd, btnSub, btnMul, btnDiv, btnDot ,btnCls, btnEq, btnBck;
    EditText et;
    float Res1 = 0.0f, Res2 = 0.0f;
    boolean Add, Sub, Mul, Div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnDot = findViewById(R.id.btnDot);
        btnCls = findViewById(R.id.btnCls);
        btnEq = findViewById(R.id.btnEq);
        btnBck = findViewById(R.id.btnBck);
        et = findViewById(R.id.et);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "0");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + ".");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et.getText() == null)
                {
                    et.setText("");
                }
                else
                {
                    Res1 = Float.parseFloat(et.getText() + "");
                    et.setText("");
                    Add = true;
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et.getText() == null)
                {
                    et.setText("");
                }
                else
                {
                    Res1 = Float.parseFloat(et.getText() + "");
                    et.setText("");
                    Mul = true;
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et.getText() == null)
                {
                    et.setText("");
                }
                else
                {
                    Res1 = Float.parseFloat(et.getText() + "");
                    et.setText("");
                    Div = true;
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et.getText() == null)
                {
                    et.setText("");
                }
                else
                {
                    Res1 = Float.parseFloat(et.getText() + "");
                    et.setText("");
                    Sub = true;
                }
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et.getText() == null)
                {
                    et.setText("");
                }
                else
                {
                    Res1 = Float.parseFloat(et.getText() + "");
                    et.setText("");
                    Add = true;
                }
            }
        });

        btnEq.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(et.getText() == null)
                {
                    et.setText("" + Res1);
                }
                else
                {
                    Res2 = Float.parseFloat(et.getText() + "");
                    et.setText("");
                }
                if(Add)
                {
                    et.setText(Res1+Res2+"");
                }
                if(Sub)
                {
                    et.setText(Res1-Res2+"");
                }
                if(Mul)
                {
                    et.setText(Res1*Res2+"");
                }
                if(Div)
                {
                    et.setText(Res1/Res2+"");
                }
            }
        });

        btnCls.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                et.setText("");
            }
        });
        btnBck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et.getText() != null)
                {
                    String s = et.getText()+"";
                    int n = s.length();
                    et.setText(s.substring(0, n-1));
                }
            }
        });







//        etVar1 = findViewById(R.id.etVar1);
//        etVar2 = findViewById(R.id.etVar2);
//        btnAdd = findViewById(R.id.btnAdd);
//        tvResult = findViewById(R.id.tvResult);

//        btnAdd.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                    int var1 = Integer.valueOf(etVar1.getText().toString());
//                    int var2 = Integer.valueOf(etVar2.getText().toString());
//
//                    int var3 = var1 + var2;
//
//                    tvResult.setText(String.valueOf(var3));
//            }
//        });
    }
}
