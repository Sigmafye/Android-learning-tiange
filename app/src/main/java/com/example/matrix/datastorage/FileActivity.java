package com.example.matrix.datastorage;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.matrix.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {
    private EditText mEtName;
    private Button mBtnSave, mBtnShow;
    private TextView mTvContent;
    private static final String M_FILE_NAME = "test.txt";
    public static final String M_FOLDER = "matrix";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        mEtName = findViewById(R.id.et_name);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTvContent = findViewById(R.id.tv_contenttt);


        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(mEtName.getText().toString().trim());
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(read());
            }
        });

    }

    //存储数据
    private void save(String content) {
        FileOutputStream fileOutputStream = null;
        try {
            //内部存储--
//            fileOutputStream = openFileOutput(M_FILE_NAME, MODE_PRIVATE);

            //外部存储
            File dir = new File(Environment.getExternalStorageDirectory(), M_FOLDER);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, M_FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);

            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null)
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    //读取数据
    private String read() {
        FileInputStream fileInputStream = null;
        try {
            //内部读取
//            fileInputStream = openFileInput(M_FILE_NAME);

            //外部读取
            String path = Environment.getExternalStorageDirectory().getAbsolutePath()
                    + File.separator + M_FOLDER;
            Log.d("storageDirectory", path);
            Log.d("storagePublicDirectory", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());
            Log.d("Ex private", getExternalCacheDir().getAbsolutePath());

            File file = new File(path, M_FILE_NAME);
            fileInputStream = new FileInputStream(file);

            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int len = 0;
            while ((len = fileInputStream.read(buff)) > 0) {
                sb.append(new String(buff, 0, len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
