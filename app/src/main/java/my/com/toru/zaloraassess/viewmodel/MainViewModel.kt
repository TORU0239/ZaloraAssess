package my.com.toru.zaloraassess.viewmodel

import android.databinding.ObservableField
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import my.com.toru.zaloraassess.Util.Util

class MainViewModel {
    companion object {
        private val TAG = MainViewModel::class.java.simpleName
    }

    val msgFromUser = ObservableField<String>("")

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
    }
}