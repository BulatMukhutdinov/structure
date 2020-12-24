package tat.mukhutdinov.android.structure.recycler

import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView
import tat.mukhutdinov.android.structure.BR

abstract class BaseViewHolder<Item, Bindings, V : ViewDataBinding>(
    protected val viewBinding: V
) : RecyclerView.ViewHolder(viewBinding.root), LifecycleOwner {

    override fun getLifecycle(): Lifecycle = lifecycleRegistry

    private val lifecycleRegistry by lazy { LifecycleRegistry(this) }

    @CallSuper
    open fun bindTo(item: Item, bindings: Bindings) {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)

        viewBinding.setVariable(BR.item, item)
        viewBinding.setVariable(BR.bindings, bindings)
        viewBinding.lifecycleOwner = this
        viewBinding.executePendingBindings()
    }

    @CallSuper
    open fun onViewRecycled() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
        viewBinding.unbind()
    }
}