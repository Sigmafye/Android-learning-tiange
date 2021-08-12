package com.example.matrix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.matrix.gridview.GridViewActivity;
import com.example.matrix.listview.ListViewActivity;
import com.example.matrix.recyclerview.RecyclerViewActivity;

public class UIActivity extends AppCompatActivity {
    private Button mBtnButton;
    private Button mBtnTextView;
    private Button mBtnEditText;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnWebView;
    private Button mBtnPopup;
    private Button mBtnRecycler;

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
        mBtnPopup = findViewById(R.id.btn_popup);
        mBtnRecycler = findViewById(R.id.btn_recyclerview);

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
        mBtnPopup.setOnClickListener(onClick);
        mBtnRecycler.setOnClickListener(onClick);
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
                case R.id.btn_popup:
                    intent = new Intent(UIActivity.this, PopupWindowActivity.class);
                    break;
                case R.id.btn_recyclerview:
                    intent = new Intent(UIActivity.this, RecyclerViewActivity.class);
                    break;
                default:
                    break;
            }
            startActivity(intent);
        }
    }
}
