package my.com.toru.zaloraassess.local

object MessageProcessor {
    private const val lengthOfEachBunch = 45
    private const val indexOfNextBunch = 46

    fun splitingMessage(message:String):ArrayList<String>{
        val result = ArrayList<String>()
        val lastIndex = message.length / lengthOfEachBunch
        for(i in 0 until lastIndex){
            val splitMsg: String = if(i == lastIndex-1){
                message.substring((indexOfNextBunch * i), message.length)
            } else{
                message.substring((indexOfNextBunch * i), (indexOfNextBunch * (i+1)))
            }
            val msgWithNumber = "${i+1}/$lastIndex".plus(" $splitMsg")
            result.add(msgWithNumber)
        }
        return result
    }
}