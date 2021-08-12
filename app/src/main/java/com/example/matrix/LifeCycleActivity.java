package com.example.matrix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        Log.d("LifeCycle", "----onCreate----");
    }

    //[home]->APP
    @Override
    protected void onStart() {
        super.onStart();

        Log.d("LifeCycle", "----onStart----");
    }

    //[get phone call] -> APP
    @Override
    protected void onResume() {
        super.onResume();

        Log.d("LifeCycle", "----onResume----");
    }

    //[phone call OR --]
    @Override
    protected void onPause() {
        super.onPause();

        Log.d("LifeCycle", "----onPause----");
    }

    //[go to other page]
    @Override
    protected void onStop() {
        super.onStop();

        Log.d("LifeCycle", "----onStop----");
    }

    //[home] -> APP
    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("LifeCycle", "----onRestart----");
    }

    //[left OR killed]
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("LifeCycle", "----onDestroy----");
    }
}
