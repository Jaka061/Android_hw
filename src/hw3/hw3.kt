package hw3

fun main() {  // HW -3 Taalaibek kyzy Zharkynai
    var num = 0
    val arr = arrayOf(4,12,22,17,7,24,2)
    for(i in 0..arr.lastIndex){   // сортировка по возрастанию
        for(j in 1..arr.lastIndex) {
            if (arr[j] < arr[j-1]) {
                num = arr[j]
                arr[j] = arr[j-1]
                arr[j-1] = num
            }
        }
    }
    for(i in 0..arr.lastIndex){
        print("${arr[i]} ; ")
    }
}