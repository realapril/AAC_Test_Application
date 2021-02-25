package aero.cubox.aactestapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        //변경된 데이터 조회
        db.todoDao().getAll().observe(this, Observer {
            txt_result.text = it.toString()
        })

        //데이터추가
        btn_add.setOnClickListener{
            lifecycleScope.launch(Dispatchers.IO) {
                db.todoDao().insert(Todo(edt_todo.text.toString()))
            }
        }
    }
}