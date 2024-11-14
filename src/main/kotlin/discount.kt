fun calculateDiscount(amount: Int, isRegularCustomer: Boolean): Int {
    if (amount < 0) {
        throw IllegalArgumentException("Amount must be non-negative")
    }
    if (amount <= 1000) {
        return 0
    }
    var out = 0
    if (amount <= 10_000) {
        out = 100
    } else {
        out = ((amount / 100) * 5).toInt()
    }
    if (isRegularCustomer) {
        out += (amount / 100)
    }
    return out
}

fun discountDemo() {
    println("Подсчитываем скидку.")
    while (true) {
        val amount = intInput("Введите сумму покупки (отрицательное число для выхода): ")
        if (amount < 0) {
            println("Спасибо, до встречи!\n")
            return
        }
        val isRegularCustomer = boolInput("Клиент постоянный? ")
        val discount = calculateDiscount(amount, isRegularCustomer)
        println("Скидка составляет $discount р.")
    }
}