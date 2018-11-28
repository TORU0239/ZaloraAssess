package my.com.toru.zaloraassess.ui

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import my.com.toru.zaloraassess.ui.adapter.MainAdapter

@BindingAdapter("adapter")
fun RecyclerView.bindRecyclerViewAdapter(recyclerView: RecyclerView, adapter:MainAdapter){
    with(recyclerView){
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(recyclerView.context)
        this.adapter = adapter
    }
}