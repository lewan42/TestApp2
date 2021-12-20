package dev.fabula.android.app.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.view.View
import dev.fabula.android.R
import dev.fabula.android.app.util.Util
import dev.fabula.android.databinding.LayoutHeaderBinding


class LayoutHeaderViewHolder(
    private val layoutHeader: LayoutHeaderBinding,
    private val context: Context
) {

    var onItemClickImage: ((View) -> Unit)? = null
    var onItemClickButtonBack: ((View) -> Unit)? = null

    fun bind(resTitleName: Int?) {
        layoutHeader.layoutHeaderText.text =
            resTitleName?.let { layoutHeader.root.context.getString(it) }
        initializeCallbacks()
    }

    fun bind(strTitleName: String?) {
        layoutHeader.layoutHeaderText.text = strTitleName
        initializeCallbacks()
    }

    fun hideLayoutImageProfile(){
        layoutHeader.layoutHeaderImage.visibility = View.INVISIBLE
    }

    private fun initializeCallbacks() {
        layoutHeader.layoutHeaderImage.setOnClickListener {
            onItemClickImage?.invoke(it)
        }

        onItemClickButtonBack ?: run {
            layoutHeader.btnBack.visibility = View.GONE
        }

        layoutHeader.btnBack.setOnClickListener {
            onItemClickButtonBack?.invoke(it)
        }

        if (Util.STATE_BLUETOOTH_CONNECTION) {
            layoutHeader.layoutHeaderBluetoothIconState.setImageResource(R.drawable.ic_bluetooth_connected)
        } else {
            layoutHeader.layoutHeaderBluetoothIconState.setImageResource(R.drawable.ic_bluetooth_disconnected)
        }

        val filter = IntentFilter(Util.ACTION_SYNC_CONNECTION_RECEIVED)
        var localState: Boolean? = null
        val receiver: BroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent) {

                var state =
                    intent.extras!!.getBoolean(Util.ACTION_SYNC_CONNECTION_RECEIVED_STATE)
                setBluetoothConnection(state)

                if (localState != null && localState as Boolean && !state) {
                    val notification: Uri =
                        RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                    val player: MediaPlayer = MediaPlayer.create(context, notification)
                    player.isLooping = false
                    if (!player.isPlaying)
                        player.start()
                }
                localState = state
            }
        }

        context.registerReceiver(receiver, filter)
    }

    fun setBluetoothConnection(isConnection: Boolean) {
        if (isConnection) {
            layoutHeader.layoutHeaderBluetoothIconState.setImageResource(R.drawable.ic_bluetooth_connected)
            Util.STATE_BLUETOOTH_CONNECTION = true
        } else {
            layoutHeader.layoutHeaderBluetoothIconState.setImageResource(R.drawable.ic_bluetooth_disconnected)
            Util.STATE_BLUETOOTH_CONNECTION = false
        }
    }
}

