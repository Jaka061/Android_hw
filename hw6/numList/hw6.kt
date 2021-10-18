package hw6.numList

/* Зная имена и номера телефонов, составьте телефонную книгу,
* в которой имена друзей сопоставлены с их соответствующими
* телефонными номерами. Затем вам будет предоставлено неизвестное
* количество имен для запроса в телефонной книге.
*
* Телефонная книга должна быть структурой данных HashMap.
*
* Формат ввода
* - Первая строка содержит целое число, обозначающее количество записей в телефонной книге.
* - Каждая из последующих строк описывает запись в виде значений, разделенных пробелами, в одной строке.
* Первое значение - это имя друга, а второе - номер телефона, состоящий из цифр.
* - После строк записей телефонной книги идет неизвестное количество строк с запросами. Каждая строка (запрос)
* содержит поиск, и вы должны продолжать читать строки, пока не введете специальную команду для выхода "exit".
*
* В новой строке для каждого запроса выведите "Not found",если имя не имеет соответствующей записи в телефонной книге;
* иначе выведите полное имя в формате name = phoneNumber.
*
* - Класс Scanner вам в помощь.
*
* Пример ввода
* > 3
* > oleg 702300300
* > sasha 500700700
* > masha 702398907
* > oleg
* > exit
*
* Пример вывода
* < oleg = 702300300
* < Not found
* < masha = 702398907
*/

fun main() {
    do {
        println("Введите число записей :")
        val x = readLine()!!.toInt()
        val phoneMap = hashMapOf<Int, List<String>>()
        var list = ArrayList<String>()

        for (i in 1..x) {
            println("Введите Имя ")
            var name1 = readLine()!!
            println("Введите номер *0...")
            var num1 = readLine()!!                                              // не закончено

            list.add(name1)
            list.add(num1)
            phoneMap[i] = list
        }


        println(phoneMap.keys)
        println(phoneMap.values)

        println("Продолжить ? НЕТ - exit ")
        var exit = readLine()!!
    }while (exit != "exit")

}

