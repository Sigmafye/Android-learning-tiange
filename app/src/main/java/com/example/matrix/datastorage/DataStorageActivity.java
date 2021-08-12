package com.example.matrix.datastorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.matrix.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {
    Button mBtnSharedPreference, mBtnFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        mBtnSharedPreference = findViewById(R.id.btn_sharedpreference);
        mBtnFile = findViewById(R.id.btn_file);

        mBtnSharedPreference.setOnClickListener(this);
        mBtnFile.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_sharedpreference:
                intent = new Intent(DataStorageActivity.this, SharedPreferencesActivity.class);
                break;
            case R.id.btn_file:
                intent = new Intent(DataStorageActivity.this, FileActivity.class);
                break;
        }
        startActivity(intent);

    }
}
