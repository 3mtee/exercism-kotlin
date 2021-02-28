class BankAccount {

    var balance: Long = 0
        private set
        get() {
            if (closed) {
                throw IllegalStateException("Account already closed")
            }
            return field
        }
    private var closed = false

    @Synchronized
    fun adjustBalance(amount: Long) {
        if (closed) {
            throw IllegalStateException("Account already closed")
        }
        balance += amount
    }

    fun close() {
        closed = true
    }
}
