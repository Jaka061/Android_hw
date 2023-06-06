package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.android.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
    ActivityMainBinding.inflate(layoutInflater)
}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonLoad.setOnClickListener {
            lifecycleScope.launch {
                loadData() // если активити умрет то и запросы отменятся
            }
        }
    }


    private suspend fun loadData() {
        binding.progress.isVisible = true
        binding.buttonLoad.isEnabled = false
        val city = loadCity()  // выходим из цикла гл.потока(метода) пока фун. полность. не выполнится
        binding.tvLocation.text = city

        val temp = loadTemperature(city) //Также выходим из метода до хаверщения метода
        binding.tvTemperature.text = temp.toString()
        binding.progress.isVisible = false
        binding.buttonLoad.isEnabled = true
    }

    private suspend fun loadCity(): String {
        delay(3000)
        return "Moscow"
    }

    private suspend fun loadTemperature(city: String): Int {
        Toast.makeText(this, "ll - $city",Toast.LENGTH_SHORT).show()
        delay(3000) // ожидание но ui поток не блокируется
        return 17
    }
}


/*
Используем потоки , callback и Handler для взаимодействия с другмим потоками
private fun loadCity(callback: (String) -> Unit) {
        thread{
            Thread.sleep(3000)
            Handler(Looper.getMainLooper()).post {
                callback.invoke("Bishkek")
            }
        }
    }

    private fun loadTemperature(city: String,callback: (Int) -> Unit){
        thread {
            runOnUiThread{
                Toast.makeText(this, "LLL - $city", Toast.LENGTH_SHORT).show()
            }
            Thread.sleep(3000)
            runOnUiThread {
                callback.invoke(17)
            }
        }
    }


    -- утечка пямяти из за отсутствия жизненого цикла потоков
* */