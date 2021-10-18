package `hw2(calc)`

fun main(){

    //********************************************** дз 2
    println("Введите число операцию (+ * - / )  ")
    val w = readLine()
    println("Введите число y:")
    val x = readLine()!!.toInt()
    println("Введите число y:")
    val y = readLine()!!.toInt()

    when (w){
        "+" -> println("Сумма $x + $y = ${x+y}")
        "*" -> println("Умножение $x * $y = ${x*y}")
        "-" -> println("Вычитание $x - $y = ${x-y}")
        "/" -> divide()
        else -> println("Такой операции нет")
    }
}
private fun divide(){
    val x1 = readLine()!!.parseToInt()
    println("Введите число y:")
    val y1 = readLine()!!.parseToInt()
    println(div(x1,y1))
}
private fun div(x1 :Int ,y1 :Int) : String {
    return try{
        "$x1 / $y1 = ${x1/y1}"
    }catch ( e: ArithmeticException ){
        "Нельзя делить на 0 !!!"
    }
}

private fun String.parseToInt():Int{
    if(this == "") return 0

    return this.toInt()
}