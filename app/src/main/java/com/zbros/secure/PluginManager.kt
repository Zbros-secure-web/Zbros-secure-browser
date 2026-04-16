package com.zbros.secure

import android.content.Context
import java.io.File

class PluginManager(private val context: Context) {

    fun initializePlugins() {
        val pluginDir = File(context.filesDir, "plugins")
        if (!pluginDir.exists()) pluginDir.mkdirs()

        // Salin plugin bawaan dari assets ke internal data
        context.assets.list("default_plugins")?.forEach { fileName ->
            val content = context.assets.open("default_plugins/$fileName").bufferedReader().use { it.readText() }
            File(pluginDir, fileName).writeText(content)
        }
    }

    fun getAllPlugins(): List<String> {
        val pluginDir = File(context.filesDir, "plugins")
        return pluginDir.listFiles()?.filter { it.extension == "js" }?.map { it.readText() } ?: emptyList()
    }
}