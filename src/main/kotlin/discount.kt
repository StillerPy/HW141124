fun calculateAmountWithDiscount(amount: Int, isRegularCustomer: Boolean): Int {
    if (amount <= 0) {
        throw IllegalArgumentException("Amount must be greater than 0")
    }
    var discount = 0.0
    if (amount <= 1000) {
        // от 0 до 1 000 рублей — скидка не предоставляется
        discount = 0.0
    }
    else if (amount <= 10_000) {
        // от 1 001 до 10 000 рублей — скидка составит 100 рублей
        discount = 100.0
    }
    else {
        // от 10 001 рубля и выше — скидка составит 5% от суммы
        discount = (amount.toDouble() / 100) * 5
    }
    var amountAfterDiscount = (amount - discount).toInt()
    if (isRegularCustomer) {
        // После стандартной скидки к получившейся сумме применяется дополнительная — ещё 1% сверху.
        amountAfterDiscount -= (amountAfterDiscount.toDouble() / 100).toInt()
    }
    return amountAfterDiscount
}


fun discountDemo() {
    println("Подсчитываем сумму со скидкой")
    while (true) {
        val amount = intInput("Введите сумму покупки (отрицательное число для выхода): ")
        if (amount < 0) {
            println("Спасибо, до встречи!\n")
            return
        }
        val isRegularCustomer = boolInput("Клиент постоянный? (y/n) ")
        val amountAfterDiscount = calculateAmountWithDiscount(amount, isRegularCustomer)
        println("Итоговая сумма: $amountAfterDiscount р.")
    }

}


















