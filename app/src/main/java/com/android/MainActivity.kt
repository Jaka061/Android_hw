package com.android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.android.databinding.ActivityMain2Binding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickListener()

        binding.apply {

            plus.setOnClickListener {
                plus()
            }
            minus.setOnClickListener {
                minus()
            }
            multiply.setOnClickListener {
                multiply()
            }
            divider.setOnClickListener {
                divider()
            }

            delete.setOnClickListener {
                delete()
            }
            result.setOnClickListener {
                result()
            }
        }
    }
    private fun txtCalc (string : String ) {
        binding.txtInput.append(string)
        if(binding.txtResult.text.isNotEmpty()){
            binding.txtResult.text=""
        }
    }

    private fun initClickListener(){
        binding.apply {
            zero.setOnClickListener { txtCalc("0") }
            one.setOnClickListener { txtCalc("1") }
            two.setOnClickListener { txtCalc("2") }
            three.setOnClickListener { txtCalc("3") }
            four.setOnClickListener { txtCalc("4") }
            five.setOnClickListener { txtCalc("5") }
            six.setOnClickListener { txtCalc("6") }
            seven.setOnClickListener { txtCalc("7") }
            eight.setOnClickListener { txtCalc("8") }
            nine.setOnClickListener { txtCalc("9") }
            openH.setOnClickListener { txtCalc("(") }
            closeH.setOnClickListener { txtCalc(")") }
            point.setOnClickListener { txtCalc(".") }
            clean.setOnClickListener {
                txtInput.text = " "
                txtResult.text = ""
            }
        }
    }

    fun minus(){
        binding.apply {
            val txt = txtInput.text.toString()
            if (txt.isNotEmpty()) {
                txtInput.append("-").toString()
            } else {
                txtInput.append("0-").toString()
            }
        }
    }

    fun plus(){
        binding.apply {
            val txt = txtInput.text.toString()
            if (txt.isNotEmpty()) {
                txtInput.append("+").toString()
            } else {
                txtInput.append("0+").toString()
            }
        }
    }

    private fun multiply(){
        binding.apply {
            val txt = txtInput.text.toString()
            if (txt.isNotEmpty()) {
                txtInput.append("*").toString()
            } else {
                txtInput.append("0*").toString()
            }
        }
    }

    private fun divider(){
        binding.apply {
            val txt = txtInput.text.toString()
            if (txt.isNotEmpty()) {
                txtInput.append("/").toString()
            } else {
                txtInput.append("0/").toString()
            }
        }
    }

    private fun delete(){
        binding.apply {
            val txt = txtInput.text.toString()
            if (txt.isNotEmpty()) {
                txtInput.text = txt.substring(0, txt.length - 1)
            }
            txtResult.text = ""
        }
    }

    private fun result(){
        binding.apply {
            try {
                val res = ExpressionBuilder(txtInput.text.toString()).build()
                val res1 = res.evaluate()

                val long = res1.toLong()
                if (res1 == long.toDouble()) {
                    txtResult.text = long.toString()
                } else {
                    txtResult.text = res1.toString()
                }
            } catch (e: ArithmeticException) {
                Log.e("Ошибка :", " $e")
                txtResult.text = "На 0 делить нельзя !"
            } catch (e: Exception) {
                Log.e("Ошибка :", " $e")
                txtResult.text = "Ошибка !"
            }
        }
    }
}