package com.messengeropener

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(@StringRes msgId: Int){
    Toast.makeText(this, getString(msgId), Toast.LENGTH_SHORT).show()
}