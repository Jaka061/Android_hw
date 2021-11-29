package com.android_ls1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    
    // hw-10: отформатировать код

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // hw-10: этот блок можно вынести в одельный метод
        zero.setOnClickListener { txtCalc("0") }
        one.setOnClickListener { txtCalc("1") }
        two.setOnClickListener { txtCalc("2") }
        three.setOnClickListener { txtCalc("3")}
        four.setOnClickListener { txtCalc("4") }
        five.setOnClickListener { txtCalc("5") }
        six.setOnClickListener { txtCalc("6") }
        seven.setOnClickListener { txtCalc("7") }
        eight.setOnClickListener { txtCalc("8") }
        nine.setOnClickListener { txtCalc("9") }

        plus.setOnClickListener {
            // hw-10: вынести в отдельный метод plus()
            var txt = txtInput.text.toString() // hw-10: -> val
            if(txt.isNotEmpty()){
                txtInput.append("+").toString()
            }else{
                txtInput.append("0+").toString()
            }
        }
        minus.setOnClickListener { var txt = txtInput.text.toString()
            // hw-10: вынести в отдельный метод minus()
            if(txt.isNotEmpty()){
                txtInput.append("-").toString()
            }else{
                txtInput.append("0-").toString()
            } }
        multiply.setOnClickListener { var txt = txtInput.text.toString()
            // hw-10: так же
            if(txt.isNotEmpty()){
                txtInput.append("*").toString()
            }
            else{
                txtInput.append("0*").toString() }
        }
        divider.setOnClickListener {
            // hw-10: так же
            var txt = txtInput.text.toString() // hw-10: -> val
            if(txt.isNotEmpty()){
                txtInput.append("/").toString()
            }else{
                txtInput.append("0/").toString()
            } }
        openH.setOnClickListener { txtCalc("(") }
        closeH.setOnClickListener { txtCalc(")") }
        point.setOnClickListener{ txtCalc(".")}

        clean.setOnClickListener {
            txtInput.text = " "
            txtResult.text = ""
        }
        delete.setOnClickListener {
            // hw-10: так же
            var txt = txtInput.text.toString() // hw-10: -> val
            if(txt.isNotEmpty()){
                txtInput.text = txt.substring(0,txt.length -1)
            }
            txtResult.text = ""
        }
        result.setOnClickListener {
            // hw-10: так же
            try {
                var res = ExpressionBuilder(txtInput.text.toString()).build() // hw-10: -> val
                var res1 = res.evaluate() // hw-10: -> val

                var long = res1.toLong() // hw-10: -> val
                if(res1 == long.toDouble()){
                    txtResult.text = long.toString()
                }else{
                    txtResult.text = res1.toString()
                }
            } catch(e:ArithmeticException){
                Log.e("Ошибка :"," $e")
                txtResult.text = "На 0 делить нельзя !"
            }catch (e:Exception){
                Log.e("Ошибка :"," $e")
                txtResult.text = "Ошибка !"
            }


        }
    }
    fun txtCalc (string : String ) {
         txtInput.append(string)
        if(txtResult.text.isNotEmpty()){
            txtResult.text=""
        }
    }

}
