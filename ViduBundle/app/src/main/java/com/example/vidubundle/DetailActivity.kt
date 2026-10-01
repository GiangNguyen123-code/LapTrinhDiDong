package com.example.vidubundle

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Lấy Bundle ra từ Intent
        val bundle = intent.extras
        if (bundle != null) {
            val name = bundle.getString("NAME", "")
            val age = bundle.getInt("AGE", 0)
            val isStudent = bundle.getBoolean("IS_STUDENT", false)

            tvResult.text = "Tên: $name\nTuổi: $age\nSinh viên: $isStudent"
        }
    }
}