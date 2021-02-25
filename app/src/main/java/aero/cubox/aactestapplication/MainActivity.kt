package aero.cubox.aactestapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()


//        txt_result.text = db.todoDao().getAll().toString()
        db.todoDao().getAll().observe(this, Observer {
            txt_result.text = it.toString()
        })

        btn_add.setOnClickListener{
            db.todoDao().insert(Todo(edt_todo.text.toString()))
//            txt_result.text = db.todoDao().getAll().toString()
        }
    }
}