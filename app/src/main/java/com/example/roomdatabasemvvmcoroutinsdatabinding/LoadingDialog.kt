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
