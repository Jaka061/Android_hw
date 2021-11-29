package com.android_ls1 // hw-8 Светофор .

import android.graphics.Color.parseColor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_sec.* // <- эта либа уже деприкэйтет, желательно ее не использовать

class MainActivity : AppCompatActivity() {

    private lateinit var  txt1 : AppCompatTextView
    private lateinit var svet : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)

        txt1 = findViewById<AppCompatTextView>(R.id.hello1)
        svet = findViewById(R.id.svetofor)
        val btn1 = findViewById<AppCompatButton>(R.id.btn1)
        val btn2 = findViewById<AppCompatButton>(R.id.btn2)
        val btn3 = findViewById<AppCompatButton>(R.id.btn3)

        btn1.setOnClickListener {
            onClick(it)
        }
        btn2.setOnClickListener {
            onClick(it)
        }
        btn3.setOnClickListener {
            onClick(it)
        }
    }
    private fun onClick(v: View){
        when(v.id){
            R.id.btn1 -> {
                txt1.text = "Красный Стой"
                svet.setBackgroundColor(parseColor("red"))   //есть разница в использовании svet и svetofor, Они одинаково работают ?
                btn1.setBackgroundColor(parseColor("white")) // в данном случае разницы нет. svet - ваша переменная, где Вы вручную инициализировали с findViewById(..svetofor)
                                                             // svetofor - эту переменную создал для Вас kotlinx.synthetic на основе идентификатора
            }
            R.id.btn2 -> {
                txt1.text = "Желтый Жди "
                svetofor.setBackgroundColor(parseColor("yellow"))
                btn2.setBackgroundColor(parseColor("white"))
            }
            R.id.btn3 -> {
                txt1.text = "Зеленый Иди "
                svetofor.setBackgroundColor(parseColor("green"))
                btn3.setBackgroundColor(parseColor("white"))
            }
        }

    }

}
