class Deque<T> {

    inner class Node<T>(internal val value: T) {
        internal var previous: Node<T>? = null
        internal var next: Node<T>? = null
    }

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun push(value: T) {
        val node = Node(value)
        if (!initIfNeeded(value)) {
            tail!!.next = node
            node.previous = head
            tail = node
        }
    }

    fun pop(): T? {
        val result = tail!!.value
        if (tail != head) {
            tail = tail!!.previous
            tail!!.next = null
        }
        return result
    }

    fun unshift(value: T) {
        val node = Node(value)
        if (!initIfNeeded(value)) {
            head!!.previous = node
            node.next = head
            head = node
        }

    }

    fun shift(): T? {
        val result = head!!.value
        if (tail != head) {
            head = head!!.next
            head!!.previous = null
        }
        return result
    }

    private fun initIfNeeded(value: T): Boolean {
        val node = Node(value)
        if (head == null || tail == null) {
            head = node
            tail = node
            return true
        }
        return false
    }
}
