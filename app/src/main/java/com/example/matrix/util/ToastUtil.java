package com.example.matrix.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

    //设置为静态的原因就是考虑连续点击
    private static Toast mToast;

    public static void showMsg(Context context, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

}