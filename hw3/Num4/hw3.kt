package hw3.Num4

import kotlin.collections.ArrayList

/* Домашнее задание, урок 2, 06.10.21
* Четырехзначное число назовем счастливым,
* если сумма первых двух ее цифр равна сумме двух последних.
* Определить, счастливое ли заданное число, вернуть true, если это так.
*/
fun main() {

    println("Введите 4x знач. число :")
    var x = readLine()!!.toInt()
    val y = x
    val arrL = ArrayList<Int>()
    if (x > 999 && x <= 9999) {
        while (x > 0) {
            arrL.add(x % 10)
            x /= 10
        }
        val rx = arrL[0] + arrL[1]
        val lx = arrL[2] + arrL[3]
        if (rx == lx) {
            println("Число $y счастливое !!!")
        }
        else{
            println("Число $y не счастливое !!!")
        }
    } else {
        println("Число не 4х значное !")
    }
//    arrL.forEach(){
//        println("e = $it" ) // по умолчанию вызывает все элементы массива
//    }
}