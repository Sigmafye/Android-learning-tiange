package com.example.matrix;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {


    private WebView mWvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWvMain = findViewById(R.id.wv);

        //加载本地HTML
//        mWvMain.loadUrl("file:///android_asset/test.html");

        //加载网络HTML
        mWvMain.setWebViewClient(new MyWebViewClient());
        mWvMain.getSettings().setJavaScriptEnabled(true);
        //Native的方法给js调用
//        mWvMain.addJavascriptInterface();
        mWvMain.setWebChromeClient(new MyWebChromeClient());
        mWvMain.loadUrl("https://m.baidu.com");

    }

    //网页的加载，监听开始和结束
    class MyWebViewClient extends WebViewClient {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            //不用调用外部浏览器
            view.loadUrl(request.getUrl().toString());
            return true;
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("webview", "onPageStarted...");
        }
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("webview", "onPageFinished...");
            //执行js代码的方式
//            mWvMain.loadUrl("javascript:alert('hello')");
//            mWvMain.evaluateJavascript("javascript:alert('world')", null);
        }
    }
    //网页设置
    class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            //把网页的标题设置成为Activity的标题
            setTitle(title);
        }
    }

    //设置网页的上一级返回
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWvMain.canGoBack()) {
            mWvMain.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
