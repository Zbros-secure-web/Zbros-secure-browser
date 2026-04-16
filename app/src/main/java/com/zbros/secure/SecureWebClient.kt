package com.zbros.secure

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class SecureWebClient(private val onPageFinishedCallback: () -> Unit) : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        val url = request?.url.toString()
        // Keamanan: Hanya izinkan protokol HTTPS
        return if (url.startsWith("https://")) {
            false
        } else {
            // Blokir atau arahkan ke versi aman jika perlu
            !url.startsWith("http://")
        }
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        onPageFinishedCallback()
    }
}