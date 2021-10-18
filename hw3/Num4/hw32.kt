package hw3.Num4
fun main() {

    println("Введите число :")
    var x = readLine()!!.toInt()

    if( x > 999 && x <= 9999){
        val x1 = x/1000%10
        val x2 = x/100%10
        val x3 = x/10%10
        val x4 = x%10
        val lx = x1+x2
        val rx = x3+x4
        if(lx == rx){
            println("Число $x счастливое")
        }
        else{
            println("Число $x не счастливое")
        }
    }
    else {
        println("Число $x не четырехзначная")
    }


}