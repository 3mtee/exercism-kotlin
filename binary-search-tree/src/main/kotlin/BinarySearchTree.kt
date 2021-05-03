class BinarySearchTree<T : Comparable<T>> {

    data class Node<T>(val data: T, var left: Node<T>? = null, var right: Node<T>? = null)

    var root: Node<T>? = null

    fun insert(value: T, node: Node<T>? = root) {
        when {
            root == null -> root = Node(value)
            node!!.data < value -> {
                if (node.right == null) {
                    node.right = Node(value)
                } else {
                    insert(value, node.right)
                }
            }
            node.data >= value -> {
                if (node.left == null) {
                    node.left = Node(value)
                } else {
                    insert(value, node.left)
                }
            }
        }

    }

    fun asSortedList(node: Node<T>? = root): List<T> = if (node == null) {
        emptyList()
    } else {
        asSortedList(node.left) + listOf(node.data) + asSortedList(node.right)
    }

    fun asLevelOrderList(): List<T> {
        val nodes = mutableListOf(root)
        var i = 0
        while (i < nodes.size) {
            if (nodes[i]?.left != null) nodes.add(nodes[i]?.left)
            if (nodes[i]?.right != null) nodes.add(nodes[i]?.right)
            i++
        }
        return nodes.filterNotNull().map { it.data }
    }

}

