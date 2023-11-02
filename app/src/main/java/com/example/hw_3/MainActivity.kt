package com.example.hw_3


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.hw_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportFragmentManager.commit {
//            replace(R.id.container, MainFragment())
//        }
    }
}

fun Fragment.navigate(fragmentClass: Class<Fragment>, bundle: Bundle? = null){
    requireActivity().supportFragmentManager.commit {
        add(R.id.container, fragmentClass,bundle, fragmentClass.name)
    }
}