package tat.mukhutdinov.android.structure.recycler

data class Diff<Item>(val oldItem: Item, val newItem: Item) {

    @Suppress("UNCHECKED_CAST")
    inline fun <reified T> asDiffOfType(): Diff<T>? =
        if (oldItem is T) {
            this as Diff<T>
        } else {
            null
        }

    companion object {

        inline fun <reified T> create(payloads: MutableList<Any>): Diff<T>? {
            if (payloads.isEmpty()) {
                return null
            }

            val first: Diff<*> = payloads.first() as? Diff<*> ?: return null
            val last: Diff<*> = payloads.last() as? Diff<*> ?: return null

            val firstDiff: Diff<T> = first.asDiffOfType() ?: return null
            val lastDiff: Diff<T> = last.asDiffOfType() ?: return null

            return Diff(firstDiff.oldItem, lastDiff.newItem)
        }
    }
}