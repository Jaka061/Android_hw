package com.android_ls1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private val zero: AppCompatButton = findViewById(R.id.zero)
    private val one :AppCompatButton = findViewById(R.id.one)
    private val two: AppCompatButton = findViewById(R.id.two)
    private val three :AppCompatButton = findViewById(R.id.three)
    private val four: AppCompatButton = findViewById(R.id.four)
    private val five :AppCompatButton = findViewById(R.id.five)
    private val six :AppCompatButton = findViewById(R.id.six)
    private val seven: AppCompatButton = findViewById(R.id.seven)
    private val eight :AppCompatButton = findViewById(R.id.eight)
    private val nine :AppCompatButton = findViewById(R.id.nine)
    private val plus :AppCompatButton = findViewById(R.id.plus)
    private val minus :AppCompatButton = findViewById(R.id.minus)
    private val multiply :AppCompatButton = findViewById(R.id.multiply)
    private val divider :AppCompatButton = findViewById(R.id.divider)
    private val result :AppCompatButton = findViewById(R.id.result)
    private val point :AppCompatButton = findViewById(R.id.point)
    private val openH :AppCompatButton = findViewById(R.id.openH)
    private val closeH :AppCompatButton = findViewById(R.id.closeH)
    private val clean :AppCompatButton = findViewById(R.id.clean)
    private val delete :AppCompatButton = findViewById(R.id.delete)
    private val txtInput :AppCompatButton = findViewById(R.id.txtInput)
    private val txtResult :AppCompatButton = findViewById(R.id.txtResult)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        OnClick()

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

    private fun OnClick(){
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
