package com.example.matrix.datastorage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matrix.R;

public class SharedPreferencesActivity extends AppCompatActivity {
    private EditText mEtName;
    private Button mBtnSave, mBtnShow;
    private TextView mTvContent;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        mEtName = findViewById(R.id.et_name);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTvContent = findViewById(R.id.tv_contenttt);

        mSharedPreferences = getSharedPreferences(" data", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putString("name", mEtName.getText().toString());
                Log.d("save:", "sucess");
                mEditor.apply();
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mSharedPreferences.getString("name", "");

                mTvContent.setText(name);
//                Toast.makeText(SharedPreferencesActivity.this, name, Toast.LENGTH_SHORT).show();
                Log.d("read:", name);
            }
        });

    }
}
