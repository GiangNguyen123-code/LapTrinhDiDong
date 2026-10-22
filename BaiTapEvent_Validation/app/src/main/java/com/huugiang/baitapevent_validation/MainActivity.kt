package com.huugiang.baitapevent_validation

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.huugiang.baitapevent_validation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRealtimeValidation()

        binding.btnRegister.setOnClickListener {
            validateAndSubmit()
        }
    }

    private fun setupRealtimeValidation() {
        binding.etFullName.doOnTextChanged { _, _, _, _ -> binding.tilFullName.error = null }
        binding.etStudentId.doOnTextChanged { _, _, _, _ -> binding.tilStudentId.error = null }
        binding.etClassRoom.doOnTextChanged { _, _, _, _ -> binding.tilClassRoom.error = null }
        binding.etEmail.doOnTextChanged { _, _, _, _ -> binding.tilEmail.error = null }
        binding.etPhone.doOnTextChanged { _, _, _, _ -> binding.tilPhone.error = null }
    }

    private fun validateAndSubmit() {
        val fullName = binding.etFullName.text?.toString()?.trim().orEmpty()
        val studentId = binding.etStudentId.text?.toString()?.trim().orEmpty()
        val classRoom = binding.etClassRoom.text?.toString()?.trim().orEmpty()
        val email = binding.etEmail.text?.toString()?.trim().orEmpty()
        val phone = binding.etPhone.text?.toString()?.trim().orEmpty()

        var isValid = true

        // 1. Kiểm tra Họ và tên (không để trống, tối thiểu 2 từ)
        if (fullName.isEmpty()) {
            binding.tilFullName.error = "Vui lòng nhập họ và tên"
            isValid = false
        } else if (fullName.length < 3) {
            binding.tilFullName.error = "Họ và tên quá ngắn"
            isValid = false
        }

        // 2. Kiểm tra MSV (không rỗng, chỉ gồm chữ/số, tối thiểu 5 ký tự)
        if (studentId.isEmpty()) {
            binding.tilStudentId.error = "Vui lòng nhập mã sinh viên"
            isValid = false
        } else if (!studentId.matches(Regex("^[a-zA-Z0-9]{5,15}$"))) {
            binding.tilStudentId.error = "MSV không hợp lệ (5-15 ký tự chữ và số)"
            isValid = false
        }

        // 3. Kiểm tra Lớp (không để trống)
        if (classRoom.isEmpty()) {
            binding.tilClassRoom.error = "Vui lòng nhập mã lớp học"
            isValid = false
        }

        // 4. Kiểm tra Email (đúng định dạng RFC)
        if (email.isEmpty()) {
            binding.tilEmail.error = "Vui lòng nhập email"
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Email không đúng định dạng (VD: example@gmail.com)"
            isValid = false
        }

        // 5. Kiểm tra Số điện thoại (chuẩn 10 số, bắt đầu bằng số 0)
        if (phone.isEmpty()) {
            binding.tilPhone.error = "Vui lòng nhập số điện thoại"
            isValid = false
        } else if (!phone.matches(Regex("^0[0-9]{9}$"))) {
            binding.tilPhone.error = "Số điện thoại phải gồm 10 chữ số và bắt đầu bằng 0"
            isValid = false
        }

        // Nếu tất cả thông tin hợp lệ -> chuyển sang DetailActivity
        if (isValid) {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("EXTRA_FULL_NAME", fullName)
                putExtra("EXTRA_STUDENT_ID", studentId)
                putExtra("EXTRA_CLASS_ROOM", classRoom)
                putExtra("EXTRA_EMAIL", email)
                putExtra("EXTRA_PHONE", phone)
            }
            startActivity(intent)
        }
    }
}