package com.example.matrix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.matrix.fragment.ContainerActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnView, mBtnToast, mBtnDialog, mBtnActivity, mBtnFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnView = findViewById(R.id.btn_view);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnDialog = findViewById(R.id.btn_dialog);
        mBtnActivity = findViewById(R.id.btn_activity);
        mBtnFragment = findViewById(R.id.btn_fragment);

        setListeners();
    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        mBtnView.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
        mBtnActivity.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_view:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_toast:
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_dialog:
                    intent = new Intent(MainActivity.this, DialogNavigateActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_activity:
                    intent = new Intent(MainActivity.this, ActivityNavigateActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }

        }
    }
}