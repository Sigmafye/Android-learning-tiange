package com.example.matrix.jump;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.matrix.R;

public class BActivity extends AppCompatActivity {
    private TextView met_name;
    private Button mbtn_return, mBtnJumpA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        met_name = findViewById(R.id.et_name);
        mbtn_return = findViewById(R.id.btn_return);
        mBtnJumpA = findViewById(R.id.btn_jump_a);

        Log.d("BActivity", "----onCreate-----");
        Log.d("BActivity", "taskId: " + getTaskId() + ", hashcode:" + hashCode());
        logTaskName();

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String name = bundle.getString("name");
        int no = bundle.getInt("number");
        met_name.setText(name + "," + no);

        mbtn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putString("return", "我回来啦~");
                intent.putExtras(bundle1);

                setResult(Activity.RESULT_OK, intent);
                finish();

            }
        });

        mBtnJumpA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AActivity.class));
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("BActivity", "----onNewIntent-----");
        Log.d("BActivity", "taskId: " + getTaskId() + ", hashcode:" + hashCode());
        logTaskName();
    }

    protected void logTaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            //获取任务栈的名称
            Log.d("BActivity", info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
