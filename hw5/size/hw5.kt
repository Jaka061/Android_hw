package hw5.size
/**
 * Найти количество цифр в заданном числе n.,
 * например, число 1 содержит 1 цифру,
 * 456 -- 3 цифры, 65536 -- 5 цифр.*/
fun main() {
    println("Введите число :")
    var x = readLine()!!.toInt()
    var len = 0;
    while (x != 0){
        len++
        x /=10
    }
    if (len == 0) {
        len = 1
    }
    println("Длина = $len")
}