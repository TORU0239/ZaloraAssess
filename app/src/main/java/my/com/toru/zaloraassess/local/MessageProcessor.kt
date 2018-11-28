package my.com.toru.zaloraassess.local

import java.util.regex.Pattern

object MessageProcessor {
    private const val REGEX = "(.{1,45}(\\W|$))"

    fun splitUserReview(message:String):ArrayList<String>{
        val m = Pattern.compile(REGEX).matcher(message)
        val list = ArrayList<String>()
        while(m.find()){
            list.add(m.group())
        }
        return list
    }
}