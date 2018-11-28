package my.com.toru.zaloraassess.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import my.com.toru.zaloraassess.Util.Util
import my.com.toru.zaloraassess.ui.adapter.MainAdapter

class MainViewModel : ViewModel() {
    companion object {
        private val TAG = MainViewModel::class.java.simpleName
    }

    val msgFromUser = ObservableField<String>()
    val msgLiveData = MutableLiveData<String>()

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

    fun onClickButton(view: View){
        Toast.makeText(view.context, "test:: ${msgFromUser.get()}", Toast.LENGTH_SHORT).show()
//        msgLiveData.value = msgFromUser.get()

        msgFromUser.get()?.filter {
            it.toString() != ""
        }?.let {
            adapter.setData(it)
        }
    }
}