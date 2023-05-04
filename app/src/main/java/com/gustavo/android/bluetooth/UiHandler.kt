package com.gustavo.android.bluetooth

import android.os.Handler
import android.os.Message

class UiHandler(
    private val messageReceivedListener: (String) -> Unit,
    private val connectionChangeListener: (Boolean) -> Unit,
) : Handler() {

    override fun handleMessage(msg: Message) {
        super.handleMessage(msg)
        when (msg.what) {
            BtThreadCommunication.MSG_TEXT -> messageReceivedListener(msg.obj.toString())
            BtThreadCommunication.MSG_CONNECTED -> connectionChangeListener(true)
            BtThreadCommunication.MSG_DISCONNECTED -> connectionChangeListener(false)
        }
    }
}
