package com.example.vidubundle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSend = findViewById<Button>(R.id.btnSend)
        btnSend.setOnClickListener {
            // Tạo Bundle đóng gói dữ liệu
            val bundle = Bundle().apply {
                putString("HO_TEN", "Nguyễn Văn A")
                putInt("TUOI", 20)
                putString("LOP", "24T3")
            }

            // Gửi Intent kèm extras (Bundle)
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtras(bundle)
            }
            startActivity(intent)
        }
    }
}