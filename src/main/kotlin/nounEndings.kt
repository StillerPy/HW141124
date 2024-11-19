fun getLikeAmountMessage(likes: Int): String {
    if (likes <= 0) {
        throw IllegalArgumentException("Negative or zero amount of likes")
    }
    if ((likes % 10) == 1 && ((likes % 100) != 11)) {
        return "Понравилось $likes человеку"
    }
    return "Понравилось $likes людям"
}

fun likeAmountMessageDemo() {
    println("Правильно склоняем существительные")
    while (true) {
        val likes = intInput("Введите количество лайков (отрицательное число или 0 для выхода): ")
        if (likes <= 0) {
            println("Спасибо, до встречи!\n")
            return
        }
        val message = getLikeAmountMessage(likes)
        println(message)
    }
}
