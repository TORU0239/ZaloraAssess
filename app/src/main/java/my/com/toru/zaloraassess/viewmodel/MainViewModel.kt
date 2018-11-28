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
import android.widget.Toast
import my.com.toru.zaloraassess.R
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
            runUploadingEvent(v)
            true
        }
        else{
            false
        }
    }

    private val handler = AbsHandler()

    fun onClickButton(view: View) {
        runUploadingEvent(view)
    }

    private fun runUploadingEvent(view:View){
        Util.hideSoftKeyboard(view)
        msgFromUser.get()?.filter {
            it.toString() != ""
        }?.let {
            if(it.length > 50){
                if(!it.contains(" ")){
                    Toast.makeText(view.context, R.string.no_whitespace, Toast.LENGTH_SHORT).show()
                }
                else{
                    sendingMessageConcurrently(MessageProcessor.splitUserReview(it))
                    msgFromUser.set("")
                }

            }
            else{
                if(it.isNotBlank()){
                    adapter.setData(it)
                    msgFromUser.set("")
                }
                else{
                    Toast.makeText(view.context, R.string.no_contents, Toast.LENGTH_SHORT).show()
                }
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
                        val splitMsg = msgList[msg.arg1].makeCounter(msg.arg1+1, msgList.size)
                        adapter.setData(splitMsg)

                        val newMSg = Message()
                        newMSg.what = 1004
                        newMSg.arg1 = (msg.arg1 + 1)
                        sendMessageDelayed(newMSg, 500)
                    }
                }
                else->{}
            }
        }
    }

    fun String.makeCounter(currentIndex:Int, size:Int) = "$currentIndex/$size ".plus(this)
}