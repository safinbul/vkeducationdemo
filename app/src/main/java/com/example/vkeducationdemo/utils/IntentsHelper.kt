package com.example.vkeducationdemo.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.net.toUri
import com.example.vkeducationdemo.SecondActivity

fun Context.openSecondActivity(text: String) {
    val intent = Intent(this, SecondActivity::class.java)
        .putExtra(SecondActivity.EXTRA_TEXT, text)
    startActivity(intent)
}

fun Context.dialPhone(phone: String) {
    tryOrToast("Не найдено приложение для звонков") {
        startActivity(Intent(Intent.ACTION_DIAL, "tel:$phone".toUri()))
    }
}

fun Context.shareText(text: String) {
    val intent = Intent(Intent.ACTION_SEND)
        .setType("text/plain")
        .putExtra(Intent.EXTRA_TEXT, text)
    tryOrToast("Не найдено приложение для отправки") {
        startActivity(Intent.createChooser(intent, "Поделиться через..."))
    }
}

private inline fun Context.tryOrToast(fallbackMessage: String, action: () -> Unit) {
    try {
        action()
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(this, fallbackMessage, Toast.LENGTH_SHORT).show()
    }
}