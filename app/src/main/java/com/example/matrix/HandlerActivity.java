package com.example.matrix;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class HandlerActivity extends AppCompatActivity {
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        //延时执行
//        mHandler = new Handler();
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(getApplicationContext(), ButtonActivity.class));
//            }
//        }, 3000);

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        Toast.makeText(HandlerActivity.this, "线程通信成功", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        new Thread() {
            @Override
            public void run() {
                super.run();
                Message message = new Message();
                message.what = 1;

                mHandler.sendMessage(message);
            }
        }.start();

    }
}
