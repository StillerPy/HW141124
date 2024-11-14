fun calculateCommission(amount: Int, minCommission: Int, percent: Double): Int {
    if (amount < 0) {
        throw IllegalArgumentException("Negative transaction amount")
    }
    if (minCommission < 0) {
        throw IllegalArgumentException("Negative minimal commission")
    }
    if (percent < 0) {
        throw IllegalArgumentException("Negative commission percent")
    }
    val commission = (amount / 100) * percent
    val out = commission.toInt()
    if (out < minCommission) {
        return minCommission
    }
    return out
}

fun commissionDemo() {
    val percent = 0.75
    val minCommission = 35
    println("Подсчитываем комиссию при денежных переводах.")
    println("Процент комиссии: $percent%. Миниальная комиссия: $minCommission р.")
    while (true) {
        val amount = intInput("Введите сумму для подсчёта комиссии (отрицательное число для выхода): ")
        if (amount < 0) {
            println("Спасибо, до встречи!\n")
            return
        }
        val commission = calculateCommission(amount, minCommission, percent)
        println("Вы ввели сумму $amount р.")
        println("Комиссия составляет $commission р.")
    }
}