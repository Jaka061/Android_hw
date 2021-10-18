package `hw4(sort)`

fun main() {  // HW -4 Taalaibek kyzy Zharkynai
    var num = 0
    val arr = arrayOf(14,12,22,17,7,24,2)
    for(i in 0..arr.lastIndex){   // сортировка по возрастанию
        for(j in 0..arr.lastIndex) {
            if (arr[i] < arr[j]) {
                num = arr[i]
                arr[i] = arr[j]
                arr[j] = num
            }
        }
    }
    for(i in 0..arr.lastIndex){
        print("${arr[i]} ; ")
    }
}
