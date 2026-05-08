package com.openappslabs.fiveg.widget

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NetworkModeBroadcastReceiver : BroadcastReceiver() {

    companion object {
        const val ACTION_NR_ONLY = "com.openappslabs.fiveg.ACTION_NR_ONLY"
        const val ACTION_NR_LTE = "com.openappslabs.fiveg.ACTION_NR_LTE"

        fun getIntent(context: Context, action: String): Intent {
            return Intent(context, NetworkModeBroadcastReceiver::class.java).apply {
                this.action = action
            }
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        // Simple way: Open the hidden Radio Info settings directly
        try {
            val intentRadio = Intent("android.intent.action.MAIN")
            intentRadio.setClassName("com.android.settings", "com.android.settings.RadioInfo")
            intentRadio.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intentRadio)

            Toast.makeText(context, "Opened Radio Info\nSelect NR Only or NR/LTE", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Toast.makeText(context, "Could not open Radio Info", Toast.LENGTH_LONG).show()
        }
    }
}
