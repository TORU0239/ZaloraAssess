package my.com.toru.zaloraassess.viewmodel

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import my.com.toru.zaloraassess.Util.Util
import my.com.toru.zaloraassess.local.MessageProcessor
import my.com.toru.zaloraassess.ui.adapter.MainAdapter

class MainViewModel : ViewModel() {
    companion object {
        private val TAG = MainViewModel::class.java.simpleName
    }

    val msgFromUser = ObservableField<String>()
    val adapter:MainAdapter = MainAdapter()

    val editorActionListener = TextView.OnEditorActionListener { v, actionId, _ ->
        if(actionId == EditorInfo.IME_ACTION_DONE){
            Log.i(TAG, "action done")
            Log.e(TAG,"inout message: ${msgFromUser.get()}")
            Util.hideSoftKeyboard(v)
            true
        }
        else{
            false
        }
    }

    private val handler = AbsHandler()

    fun onClickButton(view: View) {
        msgFromUser.set("Customer service never response. Vendor not responding to email too. 3 Orders cancelled by merchant without any explanation. Refund took weeks to process. Customer service never response. Vendor not responding to email too. 3 Orders cancelled by merchant without any explanation. Refund took weeks to process.")
        msgFromUser.get()?.filter {
            it.toString() != ""
        }?.let {
            if(it.length > 50){
                sendingMessageConcurrently(MessageProcessor.splitUserReview(it))
            }
            else{
                adapter.setData(it)
            }
        }
    }

    private fun sendingMessageConcurrently(msgList:ArrayList<String>){
        handler.msgList = msgList
        val message = Message()
        with(message){
            what = 1004
            arg1 = 0
        }
        handler.sendMessage(message)
    }

    fun onDestroy(){
        handler.removeCallbacksAndMessages(null)
    }

    @SuppressLint("HandlerLeak")
    inner class AbsHandler : Handler(){
        var msgList = ArrayList<String>()
        override fun handleMessage(msg: Message?) {
            when(msg?.what){
                1004 ->{
                    if(msg.arg1 != msgList.size){
                        adapter.setData(msgList[msg.arg1])
                        val newMSg = Message()
                        newMSg.what = 1004
                        newMSg.arg1 = (msg.arg1 + 1)
                        Log.w(TAG, "msg.arg1: ${msg.arg1}")
                        sendMessageDelayed(newMSg, 1000)
                    }
                }
                else->{}
            }
        }
    }
}