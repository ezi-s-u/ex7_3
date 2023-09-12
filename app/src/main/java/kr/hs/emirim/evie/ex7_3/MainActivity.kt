package kr.hs.emirim.evie.ex7_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.nio.file.Files

class MainActivity : AppCompatActivity() {
    lateinit var textName : TextView
    lateinit var textEmail : TextView
    lateinit var btnEnter : Button
    lateinit var editName : EditText
    lateinit var editEmail : EditText
    lateinit var textToast: TextView
    lateinit var dialogView: View   //객체 참조값을 받으려면 객체를 생성해 주어야 하는데 dialog1이나 toast1에 대한 것 그 객체 참조값을 여기다가 대입
    lateinit var toastView : View   //그래야 안에 있는 값들을 구할 수 있음

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  //이때 객체가 생성 되기 때문에 따로 할 필요가 없음
        textName = findViewById(R.id.textName)
        textEmail = findViewById(R.id.textEmail)
        btnEnter = findViewById(R.id.btnEnter)
        btnEnter.setOnClickListener {
            dialogView = View.inflate(this@MainActivity, R.layout.dialog1, null)
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("사용자 정보 입력")
            dlg.setIcon(R.drawable.icon)
            dlg.setView(dialogView)
            dlg.setPositiveButton("확인"){ dialog, i ->
                editName = dialogView.findViewById<EditText>(R.id.editName)
                editEmail = dialogView.findViewById<EditText>(R.id.editEmail)
                textName.text = editName.text.toString()
                textEmail.text = editEmail.text.toString()
            }
            dlg.setNegativeButton("취소"){
                    dialog,i->
                var toast = Toast(this@MainActivity)
                toastView = View.inflate(this@MainActivity, R.layout.toast1, null)
                textToast = toastView.findViewById(R.id.textToast)
                textToast.text = "취소되었습니다."
                toast.view = toastView
                toast.show()
            }
            dlg.show()
        }
    }
}