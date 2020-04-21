package com.example.student2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class map_activity extends AppCompatActivity {
    WebView webView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_activity);
        webView=(WebView)findViewById(R.id.webview);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        webView.setVisibility(View.INVISIBLE);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebChromeClient(new WebChromeClient(){
                                       public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                                           // callback.invoke(String origin, boolean allow, boolean remember);
                                           callback.invoke(origin, true, false);
                                       }
                                   });

                webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
            }
        });
        webView.loadUrl("https://www.google.com/maps/search/police+station+near+me/@17.3190926,74.1136041,10z/data=!3m1!4b1");



    }
}
