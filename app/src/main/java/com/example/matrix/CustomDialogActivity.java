package com.example.matrix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.matrix.util.ToastUtil;
import com.example.matrix.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button mBtn_custom_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtn_custom_dialog = findViewById(R.id.btn_custom_dialog);

        //TODO：下面的这波操作必须666喊起来，太骚了~~~
        mBtn_custom_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this, R.style.CustomDialog);
                customDialog.setTitle("提示").setMessage("确认要退出吗？")
                        .setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                            @Override
                            public void onConfirm(CustomDialog dialog) {
//                                ToastUtil.showMsg(CustomDialogActivity.this, "确认成功！");
                                Toast.makeText(CustomDialogActivity.this, "确认成功！", Toast.LENGTH_SHORT).show();
                            }
                        }).setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
//                        ToastUtil.showMsg(CustomDialogActivity.this, "已取消！");
                        Toast.makeText(CustomDialogActivity.this, "已取消", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }
}
