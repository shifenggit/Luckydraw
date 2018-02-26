package com.example.xsf.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends Activity implements OnClickListener {
    // 声明对象
    private ImageView image;
    private Button bt_pre;
    private RadioButton rbt, rbt_2, rbt_3, rbt_4;
    private TextView tV;
    Random rand = new Random();
    private int nub = 0;
    private int N = 6;
    private int[] images = { R.drawable.a, R.drawable.b, R.drawable.c,
            R.drawable.d, R.drawable.e, R.drawable.f, };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
// 初始化
        image = (ImageView) findViewById (R.id.showimage);
        bt_pre = (Button) findViewById (R.id.pre);
        rbt = (RadioButton) findViewById (R.id.radioButton);
        rbt_2 = (RadioButton) findViewById (R.id.radioButton2);
        rbt_3 = (RadioButton) findViewById (R.id.radioButton3);
        rbt_4 = (RadioButton) findViewById (R.id.radioButton4);
        tV = (TextView) findViewById(R.id.textView);
//设置监听
        bt_pre.setOnClickListener(this);
        rbt.setOnClickListener(this);
        rbt_2.setOnClickListener(this);
        rbt_3.setOnClickListener(this);
        rbt_4.setOnClickListener(this);
            }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radioButton:
                rbt_2.setChecked(false);
                rbt_3.setChecked(false);
                rbt_4.setChecked(false);
                image.setVisibility(View.INVISIBLE);
                N = 3;
                break;

            case R.id.radioButton2:
                rbt.setChecked(false);
                rbt_3.setChecked(false);
                rbt_4.setChecked(false);
                image.setVisibility(View.INVISIBLE);
                N = 4;
                break;

            case R.id.radioButton3:
                rbt.setChecked(false);
                rbt_2.setChecked(false);
                rbt_4.setChecked(false);
                image.setVisibility(View.INVISIBLE);
                N = 5;
                break;

            case R.id.radioButton4:
                rbt.setChecked(false);
                rbt_2.setChecked(false);
                rbt_3.setChecked(false);
                image.setVisibility(View.INVISIBLE);
                N = 6;
                break;

            case R.id.pre:
                image.setVisibility(View.VISIBLE);
                nub = rand.nextInt(N);
                image.setImageResource(images[nub]);
                break;
        }
    }


}