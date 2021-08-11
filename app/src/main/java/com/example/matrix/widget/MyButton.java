package com.example.matrix.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class MyButton extends AppCompatButton {

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    //所有触摸事件的从这开始分发
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("MyButton", "---dispatchTouchEvent---");
        return super.dispatchTouchEvent(event);
    }

    //基于回调
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("MyButton", "----onTouchEvent----");
                break;
        }
        //继续传播
//        return false;

        return super.onTouchEvent(event);
    }
}
