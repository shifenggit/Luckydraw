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
import android.animation.ObjectAnimator;
import android.widget.Toast;

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
        ObjectAnimator animator = null;

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
                    switch (nub) {
                        case 0:
                            image.setImageResource(images[0]);
                            // 沿X轴向移动100px，然后向左移动回到原位
                            // 沿Y轴移动，ofFloat第二个参数传入translationY
                            animator = ObjectAnimator.ofFloat(image, "translationY", 0f, 100f, 0f);
                            Toast toast = Toast.makeText (MainActivity.this, "抽到1", Toast.LENGTH_SHORT);
                            toast.show();
                            break;

                        case 1:
                            image.setImageResource(images[1]);
                            // 垂直旋转360度
                            // 水平旋转，ofFloat第二个参数传入rotationX
                            animator = ObjectAnimator.ofFloat(image, "rotationY", 0f, 360f);
                            Toast toast1 = Toast.makeText (MainActivity.this, "抽到2", Toast.LENGTH_SHORT);
                            toast1.show();
                            break;

                        case 2:
                            image.setImageResource(images[2]);
                            // 透明度从0到1
                            animator = ObjectAnimator.ofFloat(image, "alpha", 0f, 1f);
                            Toast toast2 = Toast.makeText (MainActivity.this, "抽到3", Toast.LENGTH_SHORT);
                            toast2.show();
                            break;

                        case 3:
                            image.setImageResource(images[3]);
                            // 水平缩放0.5倍，然后恢复
                            // 垂直缩放，ofFloat第二个参数传入scaleY
                            animator = ObjectAnimator.ofFloat(image, "scaleX", 1f, 0.5f, 1f);
                            Toast toast3 = Toast.makeText (MainActivity.this, "抽到4", Toast.LENGTH_SHORT);
                            toast3.show();
                            break;

                        case 4:
                            image.setImageResource(images[4]);
                            // 垂直旋转360度
                            // 水平旋转，ofFloat第二个参数传入rotationX
                            animator = ObjectAnimator.ofFloat(image, "rotationY", 0f, 360f);
                            Toast toast4 = Toast.makeText (MainActivity.this, "抽到5", Toast.LENGTH_SHORT);
                            toast4.show();
                            break;

                        case 5:
                            image.setImageResource(images[5]);
                            // 水平缩放0.5倍，然后恢复
                            // 垂直缩放，ofFloat第二个参数传入scaleY
                            animator = ObjectAnimator.ofFloat(image, "scaleX", 1f, 0.5f, 1f);
                            Toast toast5 = Toast.makeText (MainActivity.this, "抽到6", Toast.LENGTH_SHORT);
                            toast5.show();
                            break;
                    }
        }
        if (animator != null) {
            // 动画执行时长2s
            animator.setDuration(1000);
            animator.start();
        }
    }


}