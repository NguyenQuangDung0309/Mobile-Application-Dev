import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EmailCheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuan02_email) // Đảm bảo đúng tên file layout

        val etEmail = findViewById<EditText>(R.id.et_email)
        val btnCheckEmail = findViewById<Button>(R.id.btn_check_email)
        val tvResult = findViewById<TextView>(R.id.tv_email_result)

        btnCheckEmail.setOnClickListener {
            val email = etEmail.text.toString().trim()

            tvResult.text = "" // Xóa thông báo cũ
            tvResult.setTextColor(Color.RED) // Đặt màu mặc định là đỏ cho thông báo lỗi

            when {
                // 1. Nếu là null hoặc rỗng
                email.isEmpty() -> {
                    tvResult.text = "Email không hợp lệ"
                }

                // 2. Nếu không chứa "@"
                !email.contains("@") -> {
                    tvResult.text = "Email không đúng định dạng"
                }

                // 3. Email hợp lệ
                else -> {
                    tvResult.text = "Bạn đã nhập email hợp lệ"
                    tvResult.setTextColor(Color.BLUE) // Đổi màu xanh cho thông báo thành công
                }
            }
        }
    }
}