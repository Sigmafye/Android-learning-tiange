package com.example.matrix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.matrix.widget.MyButton;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnEvent, mBtnHandler;
    private MyButton btnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mBtnEvent = findViewById(R.id.btn_event);
        btnMy = findViewById(R.id.btn_my);
        btnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener", "---onTouch---");
                        break;
                }
                return false;
            }
        });
        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Listener", "---onClick---");
            }
        });

        //给同一事件源添加多个同种类型的监听器，最后设置的一个生效，先注册的不生效，最先的是布局文件里面的

        //通过内部类实现
        mBtnEvent.setOnClickListener(new OnClick());

        //匿名内部类实现
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(EventActivity.this, "anonymous class--click...", Toast.LENGTH_SHORT).show();
//            }
//        });

        //事件源所在的类实现的监听
        mBtnEvent.setOnClickListener(EventActivity.this);

        /**
         *TODO：通过外部类，记得传入
         * Toast.makeText(EventActivity.this, "activity class--click...", Toast.LENGTH_SHORT).show();
         * 所需参数
         */


        mBtnHandler = findViewById(R.id.btn_handler);
        mBtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HandlerActivity.class));
            }
        });

    }

    //事件源所在的类实现的监听
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_event:
                Toast toast = Toast.makeText(EventActivity.this, null, Toast.LENGTH_SHORT);
                toast.setText("activity class--click...");
                toast.show();
                break;
        }
    }

    //通过xml的onClick实现--android:onClick="show"
    public void show(View view) {
        switch (view.getId()) {
            case R.id.btn_event:
                Toast.makeText(EventActivity.this, "xml--click...", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_event:
                    Toast.makeText(EventActivity.this, "inner class--click...", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    //基于回调--也是为了对比MyButton的onTouchEvent
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity", "---onTouchEvent---");
                break;
        }
        return false;
    }
}
