class CheckOut {
    private var total = 0
    private var cart = mutableMapOf<String, Int>()

    fun scan(productCode: String) {
        addToCart(productCode)

        updateTotal(productCode)
    }

    private fun updateTotal(productCode: String) {
        if (productCode == "A")
            if (saleMet(productCode, 3))
                total += 30
            else
                total += 50
        if (productCode == "B")
            if (saleMet(productCode, 2))
                total += 15
            else
                total += 30
        if (productCode == "C")
            total += 20
        if (productCode == "D")
            total += 15
    }

    private fun saleMet(productCode: String, numItems: Int): Boolean {
        return cart[productCode]!! % numItems == 0
    }

    private fun addToCart(productCode: String) {
        if (cart[productCode] != null) {
            cart[productCode] = cart[productCode]!! + 1

        } else {
            cart[productCode] = 1
        }
    }

    fun total(): Int {
        return total
    }
}
