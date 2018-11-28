package my.com.toru.zaloraassess.ui.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import my.com.toru.zaloraassess.R

class MainAdapter: RecyclerView.Adapter<MainVH>() {

    private val messageList = ArrayList<String>()

    override fun onCreateViewHolder(container: ViewGroup, position: Int): MainVH {
        val inflater = LayoutInflater.from(container.context)
        return MainVH(inflater.inflate(R.layout.adapter_main, container, false))
    }

    override fun getItemCount(): Int = messageList.size

    override fun onBindViewHolder(holder: MainVH, position: Int) {
        holder.bindItem(messageList[position])
    }

    fun setData(msg:String){
        messageList.add(msg)
        notifyItemChanged(messageList.size)
    }
}

class MainVH(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bindItem(msg:String){
        Log.e("MainVH", "msg:: $msg")
    }
}