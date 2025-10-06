import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AgeCheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuan02_age)

        val etName = findViewById<EditText>(R.id.et_name)
        val etAge = findViewById<EditText>(R.id.et_age)
        val btnCheck = findViewById<Button>(R.id.btn_check)
        val tvResult = findViewById<TextView>(R.id.tv_result)

        btnCheck.setOnClickListener {
            val name = etName.text.toString().trim()
            val ageStr = etAge.text.toString().trim()

            // 1. Kiểm tra trường rỗng
            if (name.isEmpty() || ageStr.isEmpty()) {
                tvResult.text = "Vui lòng nhập đầy đủ Họ và tên và Tuổi."
                return@setOnClickListener
            }

            try {
                val age = ageStr.toInt()
                val classification = classifyAge(age)

                // 2. Hiển thị kết quả
                tvResult.text = "Xin chào $name!\nBạn ($age tuổi) là $classification."

            } catch (e: NumberFormatException) {
                tvResult.text = "Tuổi nhập vào không hợp lệ. Vui lòng nhập một số nguyên."
            }
        }
    }

    /**
     * Phân loại người dùng dựa trên tuổi theo yêu cầu bài tập
     * Người già (>=65), Người lớn (6-65), Trẻ em (2-6), Em bé (<2)
     */
    private fun classifyAge(age: Int): String {
        return when {
            age >= 65 -> "Người già"
            age >= 6 -> "Người lớn"   // 6 <= age < 65
            age >= 2 -> "Trẻ em"      // 2 <= age < 6
            else -> "Em bé"           // age < 2
        }
    }
}