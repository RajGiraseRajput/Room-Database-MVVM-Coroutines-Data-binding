package com.example.roomdatabasemvvmcoroutinsdatabinding

import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.showLoadingDialog(): AlertDialog {
    val dialogView = layoutInflater.inflate(R.layout.dialog_loading, null)
    val dialog = AlertDialog.Builder(this)
        .setView(dialogView)
        .setCancelable(false)
        .create()
    val ok = dialog.findViewById<Button>(R.id.ok)
    ok?.setOnClickListener {
        dialog.dismiss()
    }
    dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
    dialog.show()
    return dialog
}

//val prefs = getSharedPreferences("settings", Context.MODE_PRIVATE)
//prefs.edit().putString("app_lang", "fr").apply()

//override fun attachBaseContext(newBase: Context) {
//    val prefs = newBase.getSharedPreferences("settings", Context.MODE_PRIVATE)
//    val lang = prefs.getString("app_lang", "en") ?: "en"
//    val context = LocaleHelper.setLocale(newBase, lang)
//    super.attachBaseContext(context)
//}
