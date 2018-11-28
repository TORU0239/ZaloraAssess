package my.com.toru.zaloraassess.Util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

object Util {
    fun hideSoftKeyboard(view: View){
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}