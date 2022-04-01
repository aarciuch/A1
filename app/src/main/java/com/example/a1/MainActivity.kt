package com.example.a1

import android.content.Intent
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.a1.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            binding.liczba2.text = msg.arg1.toString()
            binding.progressBar2.progress = msg.arg1
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.button2.setOnClickListener {
            object : Thread() {
                override fun run() {
                    for (i in 0..100) {
                        val msg = Message()
                        msg.arg1 = i;
                        handler.sendMessage(msg)
                        sleep(500)
                        //SystemClock.sleep(500L)
                    }
                }
            }.start()
        }

        binding.button1.setOnClickListener {
            liczWtle()
        }
    }

    private fun liczWtle() {
        GlobalScope.launch(Dispatchers.Main) {
            for (i in 0..100) {
                binding.liczba1.text = i.toString()
                binding.progressBar1.progress = i
                delay(500L)
                //SystemClock.sleep(500L)
            }
        }
    }
}

