package aero.cubox.aactestapplication.activities

import aero.cubox.aactestapplication.R
import aero.cubox.aactestapplication.databinding.ActivityMainBinding
import aero.cubox.aactestapplication.vm.MainViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        binding.lifecycleOwner = this //LiveData 활용 위해서
        val viewModel: MainViewModel by viewModels()
        binding.viewModel = viewModel
    }
}