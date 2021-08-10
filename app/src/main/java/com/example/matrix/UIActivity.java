package com.example.matrix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.matrix.fragment.ContainerActivity;
import com.example.matrix.gridview.GridViewActivity;
import com.example.matrix.listview.ListViewActivity;
import com.example.matrix.jump.AActivity;
import com.example.matrix.recyclerview.RecyclerViewActivity;

public class UIActivity extends AppCompatActivity {
    private Button mBtnButton;
    private Button mBtnTextView;
    private Button mBtnEditText;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgress;
    private Button mBtnCustom;
    private Button mBtnJump;
    private Button mBtnPopup;
    private Button mBtnRecycler;
    private Button mBtnLifecycle;
    private Button mBtnFragment;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_ui);

        mBtnButton = findViewById(R.id.btn_button);
        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnEditText = findViewById(R.id.btn_edittext);
        mBtnListView = findViewById(R.id.btn_listview);
        mBtnGridView = findViewById(R.id.btn_gridview);
        mBtnWebView = findViewById(R.id.btn_webview);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnDialog = findViewById(R.id.btn_dialog);
        mBtnProgress = findViewById(R.id.btn_ProgressBar);
        mBtnCustom = findViewById(R.id.btn_custom_dialog);
        mBtnJump = findViewById(R.id.btn_jump);
        mBtnPopup = findViewById(R.id.btn_popup);
        mBtnRecycler = findViewById(R.id.btn_recyclerview);
        mBtnLifecycle = findViewById(R.id.btn_lifecycle);
        mBtnFragment = findViewById(R.id.btn_fragment);

        setLisenters();
    }

    private void setLisenters() {
        OnClick onClick = new OnClick();

        mBtnButton.setOnClickListener(onClick);
        mBtnTextView.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
        mBtnProgress.setOnClickListener(onClick);
        mBtnCustom.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
        mBtnPopup.setOnClickListener(onClick);
        mBtnRecycler.setOnClickListener(onClick);
        mBtnLifecycle.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_button:
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_textview:
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_edittext:
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_listview:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_gridview:
                    intent = new Intent(UIActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_webview:
                    intent = new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    intent = new Intent(UIActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_ProgressBar:
                    intent = new Intent(UIActivity.this, ProgressActivity.class);
                    break;
                case R.id.btn_custom_dialog:
                    intent = new Intent(UIActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.btn_jump:
                    intent = new Intent(UIActivity.this, AActivity.class);
                    break;
                case R.id.btn_popup:
                    intent = new Intent(UIActivity.this, PopupWindowActivity.class);
                    break;
                case R.id.btn_recyclerview:
                    intent = new Intent(UIActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_lifecycle:
                    intent = new Intent(UIActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(UIActivity.this, ContainerActivity.class);
                    break;
                default:
                    break;

            }
            startActivity(intent);
        }
    }
}
