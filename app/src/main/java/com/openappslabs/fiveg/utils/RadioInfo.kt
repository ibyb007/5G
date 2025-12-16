package com.openappslabs.fiveg.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.Toast

object RadioInfo {
    fun openRadioInfo(context: Context) {
        try {
            val intent = Intent("android.intent.action.MAIN")
            intent.setComponent(ComponentName("com.android.settings", "com.android.settings.RadioInfo"))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        } catch (e: Exception) {
            try {
                val intent = Intent("android.intent.action.MAIN")
                intent.setComponent(ComponentName("com.android.phone", "com.android.phone.settings.RadioInfo"))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            } catch (e2: Exception) {
                Toast.makeText(context, "Could not open Radio Info settings", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
