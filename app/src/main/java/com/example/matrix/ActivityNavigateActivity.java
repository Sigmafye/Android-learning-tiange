package com.example.matrix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.matrix.jump.AActivity;

public class ActivityNavigateActivity extends AppCompatActivity {
    Button mBtnJump, mBtnLife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pure_activity_navigate);


        mBtnJump = findViewById(R.id.btn_jump);
        mBtnLife = findViewById(R.id.btn_lifecycle);

        MyClick myClick = new MyClick();

        mBtnJump.setOnClickListener(myClick);
        mBtnLife.setOnClickListener(myClick);
    }

    class MyClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_jump:
                    startActivity(new Intent(getApplicationContext(), AActivity.class));
                    break;
                case R.id.btn_lifecycle:
                    startActivity(new Intent(getApplicationContext(), LifeCycleActivity.class));
                    break;
            }

        }
    }

}
