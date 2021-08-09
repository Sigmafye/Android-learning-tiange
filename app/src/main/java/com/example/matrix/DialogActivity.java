package com.example.matrix;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.matrix.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {
    private Button mBtnDialog1;
    private Button mBtnDialog2;
    private Button mBtnDialog3;
    private Button mBtnDialog4;
    private Button mBtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        mBtnDialog1 = findViewById(R.id.btn_dialog_1);
        mBtnDialog2 = findViewById(R.id.btn_dialog_2);
        mBtnDialog3 = findViewById(R.id.btn_dialog_3);
        mBtnDialog4 = findViewById(R.id.btn_dialog_4);
        mBtnDialog5 = findViewById(R.id.btn_dialog_5);
        OnClick onClick = new OnClick();

        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mBtnDialog5.setOnClickListener(onClick);
    }


    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_dialog_1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答!")
                            .setIcon(R.drawable.username)
                            .setMessage("你觉得我的技术怎么样?")
                            .setPositiveButton("很好", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "thumb up");
                                }
                            })
                            .setNeutralButton("一般?", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "你再瞅瞅~");
                                }
                            })
                            .setNegativeButton("不行", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "睁眼说瞎话");
                                }
                            }).show();
                    break;
                case R.id.btn_dialog_2:
                    final String[] array = new String[]{"男", "女"};
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(DialogActivity.this);
                    builder1.setTitle("选择性别：").setItems(array, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this, array[which]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog_3:
                    //选择后才可消失，点旁边不会消失
                    final String[] array2 = new String[]{"男", "女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setSingleChoiceItems(array2, 1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this, array2[which]);
                            dialog.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_dialog_4:
                    final String[] array3 = new String[]{"唱歌", "看电影", "写代码"};
                    boolean[] isSelected = new boolean[]{false, false, true};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("你的兴趣爱好是：").setMultiChoiceItems(array3, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                            ToastUtil.showMsg(DialogActivity.this, array3[which] + ":" + isChecked);
                            Toast.makeText(DialogActivity.this, array3[which] + ":" + isChecked, Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;
                case R.id.btn_dialog_5:
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog, null);

                    EditText et_username = view.findViewById(R.id.et_username);
                    EditText et_password = view.findViewById(R.id.et_password);

                    Button btn_login = view.findViewById(R.id.btn_login);
                    btn_login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // todo: ABOUT et_username et_password
                        }
                    });


                    builder4.setTitle("请先登录：").setView(view).show();
            }


        }
    }
}