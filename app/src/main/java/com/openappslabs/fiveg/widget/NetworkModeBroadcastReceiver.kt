package com.openappslabs.fiveg.widget

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.openappslabs.fiveg.utils.RadioInfo

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
        when (intent.action) {
            ACTION_NR_ONLY, ACTION_NR_LTE -> {
                RadioInfo.openRadioInfo(context)
                Toast.makeText(context, "Opened Radio Info • Choose your mode", Toast.LENGTH_LONG).show()
            }
        }
    }
}
