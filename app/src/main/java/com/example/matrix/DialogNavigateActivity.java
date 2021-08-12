package com.example.matrix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DialogNavigateActivity extends AppCompatActivity {
    private Button mBtnAlert, mBtnProgress, mBtnCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_navigate);

        mBtnAlert = findViewById(R.id.btn_alert_dia);
        mBtnCustom = findViewById(R.id.btn_custom_dia);
        mBtnProgress = findViewById(R.id.btn_progress_bar);

        MyClick myClick = new MyClick();

        mBtnAlert.setOnClickListener(myClick);
        mBtnCustom.setOnClickListener(myClick);
        mBtnProgress.setOnClickListener(myClick);
    }

    class MyClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_alert_dia:
                    startActivity(new Intent(getApplicationContext(), DialogActivity.class));
                    break;
                case R.id.btn_custom_dia:
                    startActivity(new Intent(getApplicationContext(), CustomDialogActivity.class));
                    break;
                case R.id.btn_progress_bar:
                    startActivity(new Intent(getApplicationContext(), ProgressActivity.class));
                    break;
            }

        }
    }
}
