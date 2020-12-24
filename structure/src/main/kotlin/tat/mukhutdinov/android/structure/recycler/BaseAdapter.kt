package tat.mukhutdinov.android.structure.recycler

import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<Item, Bindings, VH : BaseViewHolder<Item, Bindings, *>>(
    private val bindings: Bindings
) : RecyclerView.Adapter<VH>() {

    val items = mutableListOf<Item>()

    private val handler = Handler(Looper.getMainLooper())

    abstract fun getDiffUtil(updated: List<Item>): DiffUtil.Callback

    open fun submitList(updated: List<Item>) {
        handler.post {
            val diffResult = DiffUtil.calculateDiff(getDiffUtil(updated))
            diffResult.dispatchUpdatesTo(this)

            items.clear()
            items.addAll(updated)
        }
    }

    override fun getItemCount(): Int =
        items.size

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bindTo(items[position], bindings)

    override fun onViewRecycled(holder: VH) {
        super.onViewRecycled(holder)

        holder.onViewRecycled()
    }
}