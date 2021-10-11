package less3

import java.util.*

fun main() {
   val arr = arrayOf(1,2,3,4)
    val x = arr[2]  // 2

    arr.forEach { println(it) }
    val arrL = ArrayList<Int>(14)
    arr.forEach { println(it) }

    val linkL = LinkedList<Int>()
    linkL[0] = 0
    linkL[1] = 4
    linkL.set(3,11)

    val listL = listOf<Int>(1,2,4,7)
    // listL.set() нельзя менять значение

    val nList = listL.toMutableList()
    nList.set(3,4)
    nList.add(4,11) // по умолчанию добавляет в конец

    nList.forEach(){
        println("e = $it" ) // по умолчанию вызывает все элементы массива
    }

    //************  циклы

    for( i in 0..9){
        println("e = $i" )
    }

    while(true){
        //do
    }

//    do{
//        //do
//    } while (false)
}