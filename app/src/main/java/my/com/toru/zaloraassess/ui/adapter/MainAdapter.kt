package my.com.toru.zaloraassess.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import my.com.toru.zaloraassess.R

class MainAdapter: RecyclerView.Adapter<MainVH>() {
    override fun onCreateViewHolder(container: ViewGroup, position: Int): MainVH {
        val inflater = LayoutInflater.from(container.context)
        return MainVH(inflater.inflate(R.layout.adapter_main, container, false))
    }

    override fun getItemCount(): Int = 0

    override fun onBindViewHolder(holder: MainVH, position: Int) {
        holder.bindItem()
    }
}

class MainVH(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bindItem(){

    }
}