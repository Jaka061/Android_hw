package com.android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    private lateinit var zero : AppCompatButton
    private lateinit var one : AppCompatButton
    private lateinit var two: AppCompatButton
    private lateinit var three : AppCompatButton
    private lateinit var four: AppCompatButton
    private lateinit var five : AppCompatButton
    private lateinit var six : AppCompatButton
    private lateinit var seven: AppCompatButton
    private lateinit var eight : AppCompatButton
    private lateinit var nine : AppCompatButton
    private lateinit var plus : AppCompatButton
    private lateinit var minus : AppCompatButton
    private lateinit var multiply : AppCompatButton
    private lateinit var divider : AppCompatButton
    private lateinit var result : AppCompatButton
    private lateinit var point : AppCompatButton
    private lateinit var openH : AppCompatButton
    private lateinit var closeH : AppCompatButton
    private lateinit var clean : AppCompatButton
    private lateinit var delete : AppCompatButton
    private lateinit var txtInput : AppCompatButton
    private lateinit var txtResult : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initClickListener()

        zero = findViewById(R.id.zero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight= findViewById(R.id.eight)
        nine =findViewById(R.id.nine)
        plus = findViewById(R.id.plus)
        minus = findViewById(R.id.minus)
        multiply = findViewById(R.id.multiply)
        divider = findViewById(R.id.divider)
        result = findViewById(R.id.result)
        point = findViewById(R.id.point)
        openH = findViewById(R.id.openH)
        closeH = findViewById(R.id.closeH)
        clean = findViewById(R.id.clean)
        delete = findViewById(R.id.delete)
        txtInput = findViewById(R.id.txtInput)
        txtResult = findViewById(R.id.txtResult)

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
            divider() }

        delete.setOnClickListener {
            delete()
        }
        result.setOnClickListener {
            result()
        }
    }
    private fun txtCalc (string : String ) {
        txtInput.append(string)
        if(txtResult.text.isNotEmpty()){
            txtResult.text=""
        }
    }

    private fun initClickListener(){
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
        openH.setOnClickListener { txtCalc("(") }
        closeH.setOnClickListener { txtCalc(")") }
        point.setOnClickListener{ txtCalc(".")}
        clean.setOnClickListener {
            txtInput.text = " "
            txtResult.text = ""
        }
    }

    fun minus(){
        val txt = txtInput.text.toString()
        if(txt.isNotEmpty()){
            txtInput.append("-").toString()
        }else{
            txtInput.append("0-").toString()
        }
    }

    fun plus(){
        val txt = txtInput.text.toString()
        if(txt.isNotEmpty()){
            txtInput.append("+").toString()
        }else{
            txtInput.append("0+").toString()
        }
    }

    private fun multiply(){
        val txt = txtInput.text.toString()
        if(txt.isNotEmpty()){
            txtInput.append("*").toString()
        }
        else{
            txtInput.append("0*").toString() }
    }

    private fun divider(){
        val txt = txtInput.text.toString()
        if(txt.isNotEmpty()){
            txtInput.append("/").toString()
        }else{
            txtInput.append("0/").toString()
        }
    }

    private fun delete(){
        val txt = txtInput.text.toString()
        if(txt.isNotEmpty()){
            txtInput.text = txt.substring(0,txt.length -1)
        }
        txtResult.text = ""
    }

    private fun result(){
        try {
            val res = ExpressionBuilder(txtInput.text.toString()).build()
            val res1 = res.evaluate()

            val long = res1.toLong()
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