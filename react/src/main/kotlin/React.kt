import kotlin.properties.Delegates

class Reactor<T> {

    abstract inner class Cell {
        abstract var value: T
        val dependents = mutableListOf<ComputeCell>()
    }

    inner class InputCell(value: T) : Cell() {

        override var value by Delegates.observable(value) { _, _, _ ->
            dependents.forEach { it.propagate() }
            dependents.forEach { it.runCallbacks() }
        }
    }

    inner class ComputeCell(private val calculateValue: () -> T) : Cell() {
        override var value: T = calculateValue()

        constructor(vararg cells: Cell, f: (List<T>) -> T) :
                this({ f(cells.map { it.value }) }) {
            cells.forEach { it.dependents.add(this) }
        }

        private var lastCallbackValue = value
        private val callbacks = mutableMapOf<Int, (T) -> Any>()
        private var callbackId = 0

        fun addCallback(callback: (T) -> Any): Subscription {
            val id = callbackId++
            callbacks[id] = callback
            return object : Subscription {
                override fun cancel() {
                    callbacks.remove(id)
                }
            }
        }

        internal fun propagate() {
            val nv = calculateValue()
            if (nv == value) {
                return
            }
            value = nv
            dependents.forEach { it.propagate() }
        }

        internal fun runCallbacks() {
            if (value == lastCallbackValue) {
                return
            }
            lastCallbackValue = value
            callbacks.values.forEach { it(value) }
            dependents.forEach { it.runCallbacks() }
        }
    }

    interface Subscription {
        fun cancel()
    }
}
