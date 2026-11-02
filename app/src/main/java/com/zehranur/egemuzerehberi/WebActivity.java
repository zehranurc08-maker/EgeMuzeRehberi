package com.zehranur.egemuzerehberi;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web); // Önce tasarımı yükle

        // Tasarım yüklendikten sonra WebView'ı bul
        WebView webView = findViewById(R.id.webView);

        //  Ayarları yap
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient()); // Site uygulama içinde kalsın diye

        // Linki al ve yükle
        String url = getIntent().getStringExtra("url");
        if (url != null) {
            webView.loadUrl(url);
        }
    }
}