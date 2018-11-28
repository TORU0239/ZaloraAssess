package my.com.toru.zaloraassess.local

import java.util.regex.Pattern

object MessageProcessor {
    private const val REGEX = "(.{1,45}(\\W|$))"

    fun splitUserReview(message:String):ArrayList<String>{
        val m = Pattern.compile(REGEX).matcher(message)
        var index = 1
        val length = (message.length / 50) + 1
        println("length: $length")

        val list = ArrayList<String>()
        while(m.find()){
            println("length::" + "$index/$length ".plus(m.group()).length)
            list.add("$index/$length ".plus(m.group()))
            index+=1
        }
        return list
    }
}