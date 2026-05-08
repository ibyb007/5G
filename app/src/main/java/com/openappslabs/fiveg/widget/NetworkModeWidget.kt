package com.openappslabs.fiveg.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.actionSendBroadcast
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.text.Text

class NetworkModeWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                Column(
                    modifier = GlanceModifier.fillMaxSize().padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("5G Mode", modifier = GlanceModifier.padding(bottom = 12.dp))

                    Row(
                        modifier = GlanceModifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        androidx.glance.Button(
                            text = "NR Only",
                            modifier = GlanceModifier.defaultWeight().padding(4.dp),
                            onClick = actionSendBroadcast(NetworkModeBroadcastReceiver.getIntent(context, NetworkModeBroadcastReceiver.ACTION_NR_ONLY))
                        )

                        androidx.glance.Button(
                            text = "NR/LTE",
                            modifier = GlanceModifier.defaultWeight().padding(4.dp),
                            onClick = actionSendBroadcast(NetworkModeBroadcastReceiver.getIntent(context, NetworkModeBroadcastReceiver.ACTION_NR_LTE))
                        )
                    }
                }
            }
        }
    }
}
