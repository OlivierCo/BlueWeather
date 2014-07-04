package com.example.blueweather;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.olivier.blueweather.R;

public class MainActivity extends Activity {
	
	private WebView mWebView;

    @SuppressLint("SetJavaScriptEnabled")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        mWebView.setBackgroundColor(0x00000000);
        mWebView.loadUrl("file:///android_asset/www/index.html");

     // Stop local links and redirects from opening in browser instead of WebView
        mWebView.setWebViewClient(new MyAppWebViewClient());
        
     // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
    }
    
    @Override
    // Detect when the back button is pressed
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            // Let the system handle the back button
            super.onBackPressed();
        }
    }
}
