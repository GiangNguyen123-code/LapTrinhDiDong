package com.huugiang.baitapevent_validation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.huugiang.baitapevent_validation.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("EXTRA_FULL_NAME") ?: "N/A"
        val studentId = intent.getStringExtra("EXTRA_STUDENT_ID") ?: "N/A"
        val classRoom = intent.getStringExtra("EXTRA_CLASS_ROOM") ?: "N/A"
        val email = intent.getStringExtra("EXTRA_EMAIL") ?: "N/A"
        val phone = intent.getStringExtra("EXTRA_PHONE") ?: "N/A"

        binding.apply {
            tvDetailName.text = "Họ và tên: $name"
            tvDetailStudentId.text = "Mã sinh viên: $studentId"
            tvDetailClass.text = "Lớp: $classRoom"
            tvDetailEmail.text = "Email: $email"
            tvDetailPhone.text = "Số điện thoại: $phone"

            // Button Intent quay về màn hình trước
            btnBackToRegister.setOnClickListener {
                finish()
            }
        }
    }
}