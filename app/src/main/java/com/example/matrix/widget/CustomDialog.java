package com.example.matrix.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.matrix.R;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private TextView mTvTitle, mTvMessage, mTvCancel, mTvConfirm;
    private String title, message, cancel, confirm;
    private IOnConfirmListener confirmListener;
    private IOnCancelListener cancelListener;


    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeId) {
        super(context, themeId);
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener listener) {
        this.cancel = cancel;
        this.cancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener = listener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        //设置宽度
        WindowManager windowManager = getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        Point size = new Point();
        display.getSize(size);
        layoutParams.width = (int) (size.x * 0.8); //设置dialog的宽度为当前手机屏幕的宽度*0.8 I
        getWindow().setAttributes(layoutParams);

        mTvTitle = findViewById(R.id.tv_title);
        mTvMessage = findViewById(R.id.tv_message);
        mTvConfirm = findViewById(R.id.tv_confirm);
        mTvCancel = findViewById(R.id.tv_cancel);
        if (TextUtils.isEmpty(title)) {
            mTvTitle.setText(title);
        }
        if (TextUtils.isEmpty(message)) {
            mTvMessage.setText(message);
        }
        if (TextUtils.isEmpty(confirm)) {
            mTvConfirm.setText(confirm);
        }
        if (TextUtils.isEmpty(cancel)) {
            mTvCancel.setText(cancel);
        }
        mTvConfirm.setOnClickListener(this);
        mTvCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_confirm:
                if (confirmListener != null) {
                    confirmListener.onConfirm(this);
                }
                dismiss();
                break;
            case R.id.tv_cancel:
                if (cancelListener != null) {
                    cancelListener.onCancel(this);
                }
                dismiss();
                break;
        }
    }

    public interface IOnConfirmListener {
        void onConfirm(CustomDialog dialog);
    }

    public interface IOnCancelListener {
        void onCancel(CustomDialog dialog);
    }
}