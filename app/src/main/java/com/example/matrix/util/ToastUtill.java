package com.example.matrix.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtill {

    public static Toast mToast;
    public static void showMsg(Context context, String Msg){
        if (mToast == null){
            mToast = Toast.makeText( context,Msg,Toast.LENGTH_SHORT );
        }else {
            mToast.setText( Msg );
        }
        mToast.show();
    }

}