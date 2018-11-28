package my.com.toru.zaloraassess

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    private fun lengthOfMessage(msg:String) = msg.length


    // Check if length of given message is smaller than 50.
    @Test
    fun checkingLengthOfUserMessage(){
        val message = "Fox jumped over the window"
        assertEquals(true, lengthOfMessage(message) <= 50)
    }

    // if message is longer than threshold, we need to split by 45, cause requirement has numbering like 2/3
    @Test
    fun splitLongMessage(){
        val lengthOfEachBunch = 45
        val indexOfNextBunch = 46
        val message = "Customer service never response. Vendor not responding to email too. 3 Orders cancelled by merchant without any explanation. Refund took weeks to process."

        val list = ArrayList<String>()
        val lastIndex = message.length / lengthOfEachBunch
        for(i in 0 until lastIndex){
            val test: String = if(i == lastIndex-1){
                message.substring((indexOfNextBunch * i), message.length)
            } else{
                message.substring((indexOfNextBunch * i), (indexOfNextBunch * (i+1)))
            }
            val test2 = "${i+1}/$lastIndex".plus(" $test")
            list.add(test2)
            assertEquals(true, test2.contains("/"))
        }

        assertEquals(3, list.size)
        assertEquals(true, lastIndex == list.size)
    }
}