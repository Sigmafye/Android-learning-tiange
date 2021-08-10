package com.example.matrix.fragment;

import android.nfc.Tag;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.matrix.R;

public class ContainerActivity extends AppCompatActivity {
    private AFragment aFragment;
//    private BFragment bFragment;
//    private Button mBtnChange;
    boolean tag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
//        mBtnChange = findViewById(R.id.btn_change);
//
//        mBtnChange.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (bFragment == null) {
//                    bFragment = new BFragment();
//                }
//                //反复横跳
//                if (tag) {
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).commitAllowingStateLoss();
//                    tag = false;
//                } else {
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, aFragment).commitAllowingStateLoss();
//                    tag = true;
//                }
//            }
//        });

        //实例化AFragment
        aFragment = AFragment.newInstance("我是参数");

        //把AFragment添加到Activity中
//        getFragmentManager().beginTransaction().add(R.id.fl_container, aFragment).commitAllowingStateLoss();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment, "tagA").commitAllowingStateLoss();
        tag = true;
    }

}
