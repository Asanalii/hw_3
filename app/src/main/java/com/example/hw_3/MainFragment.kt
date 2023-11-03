package com.example.hw_3

import androidx.navigation.fragment.findNavController
import com.example.hw_3.base.BaseFragment
import com.example.hw_3.databinding.FragmentMainBinding

class MainFragment: BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate ) {

    override fun onBindView() {
        super.onBindView()

        binding.getStarted.setOnClickListener{
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToArchiveFragment("Hello second fragment")
            )
        }
    }
}

enum class ArgumentKey{
    NAME,
}
