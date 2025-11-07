package com.jozef.recipeapp;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class PrivacyPolicyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        // Load privacy policy HTML content into WebView
        WebView webView = findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true); // Optional: Enable JavaScript if needed
        webView.loadUrl(getString(R.string.privacy_policy_html_file));
    }
}
