package my.com.toru.zaloraassess.ui.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import my.com.toru.zaloraassess.R
import my.com.toru.zaloraassess.databinding.AdapterMainBinding

class MainAdapter: RecyclerView.Adapter<MainVH>() {

    private val messageList = ArrayList<String>()

    override fun onCreateViewHolder(container: ViewGroup, position: Int): MainVH {
        val databinding:AdapterMainBinding = DataBindingUtil.inflate(LayoutInflater.from(container.context), R.layout.adapter_main, container, false)
        return MainVH(databinding)
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

class MainVH(private val binding:AdapterMainBinding): RecyclerView.ViewHolder(binding.root){
    fun bindItem(msg:String){
        Log.e("MainVH", "msg:: $msg")
        binding.message = msg
        binding.executePendingBindings()
    }
}