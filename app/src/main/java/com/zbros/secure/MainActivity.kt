package com.zbros.secure

import android.os.Bundle
import android.webkit.*
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        val urlInput = findViewById<EditText>(R.id.urlInput)
        val btnGo = findViewById<Button>(R.id.btnGo)

        setupSecureWebView()

        btnGo.setOnClickListener {
            val url = urlInput.text.toString()
            if (url.startsWith("http")) webView.loadUrl(url) 
            else webView.loadUrl("https://www.google.com/search?q=$url")
        }
    }

    private fun setupSecureWebView() {
        val settings = webView.settings
        settings.javaScriptEnabled = true // Wajib untuk plugin
        settings.domStorageEnabled = true
        
        // FITUR KEAMANAN ZBROS
        settings.allowFileAccess = false // Jangan izinkan akses file sistem via browser
        settings.allowContentAccess = false
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, false) // Blokir cookie pihak ketiga

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                injectInternalPlugins() // Suntikkan plugin setiap halaman selesai dimuat
            }
        }
    }

    private fun injectInternalPlugins() {
        // Lokasi folder: /data/user/0/com.zbros.secure/files/plugins
        val pluginDir = File(filesDir, "plugins")
        if (!pluginDir.exists()) pluginDir.mkdirs()

        pluginDir.listFiles()?.forEach { file ->
            if (file.extension == "js") {
                val script = file.readText()
                webView.evaluateJavascript(script, null)
            }
        }
    }
}