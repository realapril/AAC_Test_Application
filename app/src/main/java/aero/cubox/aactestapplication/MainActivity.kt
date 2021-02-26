package aero.cubox.aactestapplication

import aero.cubox.aactestapplication.vm.MainViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: MainViewModel by viewModels()
        //변경된 데이터 조회
        viewModel.getAll().observe(this, Observer {
            txt_result.text = it.toString()
        })

        //데이터추가
        btn_add.setOnClickListener{
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.insert(edt_todo.text.toString())
            }
        }
    }
}