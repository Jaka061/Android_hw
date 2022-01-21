package hw1 //calc

fun main(){

    println("Введите число операцию (+ * - / )  ")
    val w = readLine()
    println("Введите число x:")
    val x = readLine()!!.parseToInt()
    println("Введите число y:")
    val y = readLine()!!.parseToInt()

    when (w){
        "+" -> println("Сумма $x + $y = ${x+y}")
        "*" -> println("Умножение $x * $y = ${x*y}")
        "-" -> println("Вычитание $x - $y = ${x-y}")
        "/" -> divide(x,y)
        else -> println("Такой операции нет")
    }
}
private fun divide(x1 :Int ,y1 :Int) {
   if(y1 != 0 ) {
       (x1 / y1).toString()
   }
   else{
       println("Нельзя делить на 0 !!!")
    }
}
private fun String.parseToInt():Int{
    if(this == "") return 0
    return this.toInt()
}
