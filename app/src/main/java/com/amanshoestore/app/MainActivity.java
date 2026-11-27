package com.amanshoestore.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private static final int FILE_CHOOSER_REQUEST = 4102;
    private WebView webView;
    private ValueCallback<Uri[]> filePathCallback;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        webView = new WebView(this);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        webView.setWebViewClient(new WebViewClient() {
            private boolean openExternal(Uri uri) {
                String scheme = uri.getScheme() == null ? "" : uri.getScheme().toLowerCase();
                try {
                    if ("tel".equals(scheme)) {
                        startActivity(new Intent(Intent.ACTION_DIAL, uri));
                        return true;
                    }
                    if ("whatsapp".equals(scheme)) {
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                        return true;
                    }
                    if ("mailto".equals(scheme)) {
                        startActivity(new Intent(Intent.ACTION_SENDTO, uri));
                        return true;
                    }
                } catch (ActivityNotFoundException ignored) {
                    return true;
                }
                return false;
            }
            @Override public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return openExternal(request.getUrl());
            }
            @SuppressWarnings("deprecation")
            @Override public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return openExternal(Uri.parse(url));
            }
        });
        webView.addJavascriptInterface(new AndroidShareBridge(), "AndroidShare");
        webView.setWebChromeClient(new WebChromeClient() {
            @Override public boolean onShowFileChooser(WebView view,
                    ValueCallback<Uri[]> callback, FileChooserParams params) {
                if (filePathCallback != null) filePathCallback.onReceiveValue(null);
                filePathCallback = callback;
                Intent intent;
                try {
                    intent = params.createIntent();
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    startActivityForResult(intent, FILE_CHOOSER_REQUEST);
                } catch (ActivityNotFoundException ex) {
                    filePathCallback = null;
                    return false;
                }
                return true;
            }
        });
        webView.setBackgroundColor(0xFFF5F7FB);
        setContentView(webView);
        if (savedInstanceState == null) {
            webView.loadUrl("file:///android_asset/index.html");
        } else {
            webView.restoreState(savedInstanceState);
        }
    }

    public class AndroidShareBridge {
        @JavascriptInterface
        public void callPhone(String phone) {
            runOnUiThread(() -> {
                String digits = phone == null ? "" : phone.replaceAll("[^0-9]", "");
                if (digits.isEmpty()) return;
                try {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + digits)));
                } catch (ActivityNotFoundException ex) {
                    new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Phone dialer available nahi hai.")
                        .setPositiveButton("OK", null).show();
                }
            });
        }

        @JavascriptInterface
        public void openWhatsApp(String phone) {
            runOnUiThread(() -> {
                String digits = phone == null ? "" : phone.replaceAll("[^0-9]", "");
                if (digits.length() == 10) digits = "91" + digits;
                else if (digits.length() == 11 && digits.startsWith("0")) digits = "91" + digits.substring(1);
                if (digits.isEmpty()) return;
                try {
                    Intent whatsapp = new Intent(Intent.ACTION_VIEW, Uri.parse("whatsapp://send?phone=" + digits));
                    startActivity(whatsapp);
                } catch (ActivityNotFoundException ex) {
                    try {
                        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/" + digits));
                        startActivity(browser);
                    } catch (ActivityNotFoundException ignored) {
                        new AlertDialog.Builder(MainActivity.this)
                            .setMessage("WhatsApp ya browser available nahi hai.")
                            .setPositiveButton("OK", null).show();
                    }
                }
            });
        }

        @JavascriptInterface
        public void exitApp() {
            runOnUiThread(() -> MainActivity.this.finish());
        }

        @JavascriptInterface
        public void shareText(String text) {
            runOnUiThread(() -> {
                Intent send = new Intent(Intent.ACTION_SEND);
                send.setType("text/plain");
                send.putExtra(Intent.EXTRA_SUBJECT, "Aman Shoe Store Product");
                send.putExtra(Intent.EXTRA_TEXT, text == null ? "Aman Shoe Store" : text);
                startActivity(Intent.createChooser(send, "Share product via"));
            });
        }
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_CHOOSER_REQUEST) {
            if (filePathCallback != null) {
                Uri[] results = null;
                if (resultCode == RESULT_OK && data != null) {
                    android.content.ClipData clipData = data.getClipData();
                    if (clipData != null && clipData.getItemCount() > 0) {
                        results = new Uri[clipData.getItemCount()];
                        for (int i = 0; i < clipData.getItemCount(); i++) {
                            results[i] = clipData.getItemAt(i).getUri();
                        }
                    } else {
                        Uri uri = data.getData();
                        if (uri != null) results = new Uri[]{uri};
                    }
                }
                filePathCallback.onReceiveValue(results);
                filePathCallback = null;
            }
        }
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        if (webView != null) webView.saveState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
            return;
        }
        new AlertDialog.Builder(this)
                .setTitle("Exit Aman Shoe Store?")
                .setMessage("Kya aap app band karna chahte hain?")
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .setPositiveButton("Exit", (dialog, which) -> finish())
                .show();
    }

    @Override protected void onDestroy() {
        if (filePathCallback != null) {
            filePathCallback.onReceiveValue(null);
            filePathCallback = null;
        }
        super.onDestroy();
    }
}
