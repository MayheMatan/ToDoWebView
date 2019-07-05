package com.mayhematan.todowebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView ob = new WebView(this);//create one webview
        ob.getSettings().setJavaScriptEnabled(true);
        ob.getSettings().setAllowFileAccess(true);
        ob.getSettings().setAppCacheEnabled(true);
        WebSettings webSettings = ob.getSettings();
        webSettings.setJavaScriptEnabled ( true );
        ob.loadUrl("file:///android_asset/www/index.html");//move to the login page
        ob.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        ob.addJavascriptInterface(new WebAppInterface(this), "Android");
        //opens all link in the same web view instead of the default browser
        ob.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });

        setContentView(ob);

    }
    @Override
    public void onBackPressed () {
        return;} //No BackButton is used
}

