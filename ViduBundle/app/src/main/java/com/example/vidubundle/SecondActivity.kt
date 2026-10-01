package com.example.vidubundle

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvKetQua = findViewById<TextView>(R.id.tvKetQua)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // 1. Nhận Bundle từ extras và hiển thị thông tin
        val bundle = intent.extras
        if (bundle != null) {
            val hoTen = bundle.getString("HO_TEN", "")
            val tuoi = bundle.getInt("TUOI", 0)
            val lop = bundle.getString("LOP", "")

            tvKetQua.text = "Họ tên: $hoTen\nTuổi: $tuoi\nLớp: $lop"
        }

        // 2. Xử lý sự kiện nút Back quay lại màn hình 1
        btnBack.setOnClickListener {
            finish() // Đóng SecondActivity để trở về MainActivity
        }
    }
}