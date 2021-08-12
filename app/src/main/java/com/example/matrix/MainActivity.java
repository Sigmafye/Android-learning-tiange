package com.example.matrix;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.matrix.broadcast.BroadActivity;
import com.example.matrix.datastorage.DataStorageActivity;
import com.example.matrix.fragment.ContainerActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnView, mBtnToast, mBtnDialog,
            mBtnActivity, mBtnFragment, mBtnEvent, mBtnData, mBtnBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnView = findViewById(R.id.btn_view);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnDialog = findViewById(R.id.btn_dialog);
        mBtnActivity = findViewById(R.id.btn_activity);
        mBtnFragment = findViewById(R.id.btn_fragment);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnData = findViewById(R.id.btn_data);
        mBtnBroadcast = findViewById(R.id.btn_broadcast);

        setListeners();

        //TODO:此处应该为一完整体系，动态请求外部存储的权限。重点：sdk23以后！！！
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, 1);
    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        mBtnView.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
        mBtnActivity.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
        mBtnBroadcast.setOnClickListener(onClick);
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
                case R.id.btn_broadcast:
                    intent = new Intent(MainActivity.this, BroadActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }

        }
    }
}